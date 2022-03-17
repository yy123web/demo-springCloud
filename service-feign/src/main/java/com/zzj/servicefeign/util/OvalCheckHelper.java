package com.zzj.servicefeign.util;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.exception.ConstraintsViolatedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaozj37918
 * @date 2022年03月04日 17:33
 */
public class OvalCheckHelper {
    public static void validate(Object obj) throws Exception {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(obj);
        if ( violations != null && violations.size() > 0 ) {
            ConstraintViolation violation = violations.get(0);
            String errorCode = violation.getErrorCode();
            String message = violation.getMessage();
            Map<String,Map> map = new HashMap<>();
            Map<String,String> head = new HashMap<>();
            head.put("errorCode:",errorCode);
            head.put("message:",message);
            map.put("head",head);

            throw new ConstraintsViolatedException(violations);
        }
    }
}
