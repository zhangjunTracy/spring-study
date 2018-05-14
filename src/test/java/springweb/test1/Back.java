package springweb.test1;

public class Back {

    /*
     * List<Integer> userIds = null; // 普通用户 if (0 == member) { String
     * sqlHuiyuan =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND ((orderable_type='App\\\\Prime' AND orderable_id=1 ) OR (orderable_type='App\\\\Prime' AND orderable_id=1)  OR (orderable_type='App\\\\Membership' AND orderable_id IN (1,2,3,4))OR (orderable_type='App\\PaperBookService' AND orderable_id=1))"
     * ; List<Integer> list = jdbcTemplate.queryForList(sqlHuiyuan,
     * Integer.class); if (CollectionUtils.isEmpty(list)) { list.add(-1); }
     * StringBuffer sqlPutong = new StringBuffer(
     * "SELECT id FROM users_info WHERE id NOT IN(");
     * sqlPutong.append(StringUtils.join(list, ",")); sqlPutong.append(")");
     * userIds = jdbcTemplate.queryForList(sqlPutong.toString(), Integer.class);
     * // 超级会员 } else if (5 == member) { LocalDate nDate = LocalDate.now(); //
     * 会员有效 if (nDate.isBefore(ENDDATE)) { // 已过期的是没有的 if (status == 2) {
     * userIds = new ArrayList<>(); } else { userIds =
     * superVipRepository.findByStatus(); } } else { // 没有不过期的 if (status == 1)
     * { userIds = new ArrayList<>(); } else { userIds =
     * superVipRepository.findByStatus(); } } // 12+ 会员 } else if (4 == member)
     * { // 全部 if (0 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\PaperBookService' AND orderable_id=1"
     * ; userIds = jdbcTemplate.queryForList(sql, Integer.class); // 未过期 } else
     * if (1 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\PaperBookService' AND orderable_id=1"
     * ; userIds = jdbcTemplate.queryForList(sql, Integer.class); // 过期的 } else
     * { String sql1 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\PaperBookService' AND orderable_id=1"
     * ; List<Integer> list = jdbcTemplate.queryForList(sql1, Integer.class);
     * String sql2 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\PaperBookService' AND orderable_id=1"
     * ; List<Integer> list2 = jdbcTemplate.queryForList(sql2, Integer.class);
     * list.removeAll(list2); userIds = new ArrayList<>(list); } // 一书一课会员 }
     * else if (3 == member) { // 全部 if (0 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\Serial' AND orderable_id=1"
     * ; userIds = jdbcTemplate.queryForList(sql, Integer.class); // 未过期 } else
     * if (1 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\Serial' AND orderable_id=1"
     * ; userIds = jdbcTemplate.queryForList(sql, Integer.class); // 过期的 } else
     * { String sql1 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\Serial' AND orderable_id=1"
     * ; List<Integer> list = jdbcTemplate.queryForList(sql1, Integer.class);
     * String sql2 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\Serial' AND orderable_id=1"
     * ; List<Integer> list2 = jdbcTemplate.queryForList(sql2, Integer.class);
     * list.removeAll(list2); userIds = new ArrayList<>(list); } // 听书卡 } else
     * if (2 == member) { StringBuffer typesql = new StringBuffer(
     * " AND orderable_id IN("); if (type.contains(0)) {
     * typesql.append("1,2,3,4"); } else { typesql.append(StringUtils.join(type,
     * ",")); } typesql.append(")"); // 全部 if (0 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\Membership' "
     * + typesql.toString(); userIds = jdbcTemplate.queryForList(sql,
     * Integer.class); // 未过期 } else if (1 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\Membership' "
     * + typesql.toString(); userIds = jdbcTemplate.queryForList(sql,
     * Integer.class); // 过期的 } else { String sql1 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\Membership' "
     * + typesql.toString(); List<Integer> list =
     * jdbcTemplate.queryForList(sql1, Integer.class); String sql2 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\Membership' "
     * + typesql.toString(); List<Integer> list2 =
     * jdbcTemplate.queryForList(sql2, Integer.class); list.removeAll(list2);
     * userIds = new ArrayList<>(list); }
     * 
     * } else if (1 == member) { // 全部 if (0 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\Prime' AND orderable_id=1"
     * ; userIds = jdbcTemplate.queryForList(sql, Integer.class); // 未过期 } else
     * if (1 == status) { String sql =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\Prime' AND orderable_id=1"
     * ; userIds = jdbcTemplate.queryForList(sql, Integer.class); // 过期的 } else
     * { String sql1 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL  AND orderable_type='App\\\\Prime' AND orderable_id=1"
     * ; List<Integer> list = jdbcTemplate.queryForList(sql1, Integer.class);
     * String sql2 =
     * "SELECT user_id FROM orders WHERE trade_state='SUCCESS' AND deleted_at IS NULL AND created_at<NOW() AND END_TIME >NOW() AND orderable_type='App\\\\Prime' AND orderable_id=1"
     * ; List<Integer> list2 = jdbcTemplate.queryForList(sql2, Integer.class);
     * list.removeAll(list2); userIds = new ArrayList<>(list); } } Set<Integer>
     * set = new HashSet<>(userIds); return null;
     */
}
