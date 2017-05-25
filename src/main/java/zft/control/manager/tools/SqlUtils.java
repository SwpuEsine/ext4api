package zft.control.manager.tools;


import org.hibernate.Query;

public class SqlUtils {

    public static void addSql(StringBuffer sqlBuf, String sqlColumn, Object param) {
        if (StringUtils.isNotNull(param)) {
            sqlBuf.append(" and ").append(sqlColumn);
        }
    }

    public static String addBSql(StringBuffer sqlBuf, String sqlColumn, String start, String end) {
        if (StringUtils.isNotNull(start)) {
            end = StringUtils.isNotNull(end) ? end : start;
            sqlBuf.append(" and ").append(sqlColumn);
        }
        return end;
    }

    public static void setParameter(Query query, String key, Object value) {
        if (StringUtils.isNotNull(value)) {
            if (value instanceof String) {
                query.setParameter(key, value.toString().trim());
            } else {
                query.setParameter(key, value);
            }
        }
    }

    public static void setParameterList(Query query, String key, Object[] value) {
        if (value != null && value.length != 0) {
            query.setParameterList(key, value);
        }
    }

    public static void setParameterLike(Query query, String key, Object value) {
        if (StringUtils.isNotNull(value)) {
            if (value instanceof String) {
                query.setParameter(key, "%" + value.toString().trim() + "%");
            } else {
                query.setParameter(key, "%" + value + "%");
            }
            query.setParameter(key, "%" + value + "%");
        }
    }
}
