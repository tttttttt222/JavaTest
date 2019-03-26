package com.test.sqlgendao;


/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/3/26
 */
public class SqlGenDao {

	private final static boolean isAllString = false;


	private final static String sqlString = " `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',\n"
			+ "  `order_id` bigint(20) NOT NULL COMMENT '订单号',\n"
			+ "  `member_trans_id` varchar(32) NOT NULL COMMENT '商户订单号',\n"
			+ "  `member_id` bigint(20) NOT NULL COMMENT '商户号',\n"
			+ "  `payee_member_id` bigint(20) NOT NULL COMMENT '收款商户号',\n"
			+ "  `amount` decimal(18,2) NOT NULL COMMENT '金额',\n"
			+ "  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态 0:失败 1:成功 2:处理中',\n"
			+ "  `order_type` tinyint(4) NOT NULL COMMENT '订单类型 1:本金 2:佣金 3:差价 4:还款',\n"
			+ "  `business_type` tinyint(4) NOT NULL COMMENT '业务类型 1:借款 2:付款 3:还款',\n"
			+ "  `pay_state` tinyint(4) NOT NULL COMMENT '支付状态 1:未付 2:已付',\n"
			+ "  `bill_id` varchar(32) NOT NULL COMMENT '票号',\n"
			+ "  `loan_order_id` varchar(32) NOT NULL COMMENT '借款订单号',\n"
			+ "  `remark` varchar(512) DEFAULT NULL COMMENT '备注',\n"
			+ "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n"
			+ "  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',";


	public static void main(String[] args) {
		String[] fields = sqlString.split(",\n");
		for (String field : fields) {
			field = field.replaceAll("`", "");
			field = field.replaceAll("\\s+", " ");
			//分解
			String brief = getBrief(field);
			String parm = getParm(field);
			String type = getType(brief);
			String comment = getComment(brief);
			String parmFormat = transSybParm(parm);

			String out = "private " + type + " " + parmFormat + ";";
			System.out.println("//" + comment);
			System.out.println(out);
			System.out.println();
		}

	}

	private static String transSybParm(String parm) {
		while (parm.indexOf("_") != -1) {
			int pin = parm.indexOf("_");
			parm = parm.substring(0, pin) + parm.substring(pin + 1, pin + 2).toUpperCase() + parm
					.substring(pin + 2);
		}
		return parm;
	}

	private static String getComment(String brief) {
		int start = brief.indexOf("COMMENT");
		if (start == -1) {
			return "";
		}
		start = brief.indexOf("'", start);
		int end = brief.indexOf("'", start + 1);
		String comment = brief.substring(start + 1, end);
		return comment;
	}

	private static String getType(String brief) {
		if (isAllString) {
			return "String";
		} else {
			int end = brief.indexOf("(");
			int start = brief.indexOf(" ", 1);
			if (end == -1) {
				end = brief.indexOf(" ", start + 1);
			}
			String substring = brief.substring(start + 1, end);
			switch (substring) {
				case "bigint":
					return "Long";
				case "varchar":
					return "String";
				case "tinyint":
					return "Integer";
				case "timestamp":
					return "Date";
				case "decimal":
					return "BigDecimal";
				default:
					return "String";
			}
		}
	}

	private static String getParm(String field) {
		int i = field.indexOf(" ", 1);
		String parm = field.substring(0, i);
		return parm;
	}

	private static String getBrief(String field) {
		int i = field.indexOf(" ", 1);
		String brief = "//" + field.substring(i);
		return brief;
	}

}
