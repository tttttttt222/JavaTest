package com.test.sqlgendao;


import java.util.ArrayList;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/3/26
 */
public class SqlGenDaoUpdate {

	private final static boolean isAllString = false;


	private final static String sqlString = " `id` bigint(20) NOT NULL AUTO_INCREMENT,\n"
			+ "  `order_type` int(11) NOT NULL COMMENT '0 1A->A1 2A->B1 3A1->B1 4A1->A2 5A1->B',\n"
			+ "  `payer_platform_no` int(11) NOT NULL COMMENT '付款方平台',\n"
			+ "  `terminal_id` int(11) NOT NULL COMMENT '终端',\n"
			+ "  `trans_serial_no` varchar(50) NOT NULL COMMENT '商户订单号',\n"
			+ "  `payer_contract_no` varchar(50) DEFAULT NULL COMMENT '付款方',\n"
			+ "  `payee_platform_no` int(11) DEFAULT NULL COMMENT '收款方平台',\n"
			+ "  `payee_contract_no` varchar(50) DEFAULT NULL COMMENT '收款方',\n"
			+ "  `order_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0初始化 1成功 2失败',\n"
			+ "  `trans_amt` decimal(10,2) NOT NULL COMMENT '交易金额',\n"
			+ "  `fee_acct_id` int(11) DEFAULT NULL COMMENT '手续费账户类型',\n"
			+ "  `trans_fee_amt` decimal(10,2) DEFAULT '0.00' COMMENT '手续费',\n"
			+ "  `product_id` int(11) DEFAULT NULL COMMENT '产品',\n"
			+ "  `function_id` int(11) DEFAULT NULL COMMENT '功能',\n"
			+ "  `business_no` varchar(255) DEFAULT NULL,\n"
			+ "  `remark` varchar(512) DEFAULT NULL,\n"
			+ "  `rem1` varchar(200) DEFAULT NULL COMMENT '预留字段1',\n"
			+ "  `rem2` varchar(200) DEFAULT NULL COMMENT '预留字段2',\n"
			+ "  `rem3` varchar(200) DEFAULT NULL COMMENT '预留字段3',\n"
			+ "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n"
			+ "  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',";

	private static String dtoName = "";

	public static void main(String[] args) {
		String[] fields = sqlString.split(",\n");
		ArrayList<SqlDaoParmGenDto> sqlDaoParmGenDtos = new ArrayList<>();
		for (String field : fields) {
			field = field.replaceAll("`", "");
			field = field.replaceAll("\\s+", " ");
			sqlDaoParmGenDtos.add(new SqlDaoParmGenDto().bulid(field, false));
		}

		for (SqlDaoParmGenDto sqlDaoParmGenDto : sqlDaoParmGenDtos) {
			String out = "private " + sqlDaoParmGenDto.getType() + " " + sqlDaoParmGenDto.getParmFormat() + ";";
			System.out.println("//" + sqlDaoParmGenDto.getComment());
			System.out.println(out);
			System.out.println();
		}

		System.out.println();
		for (SqlDaoParmGenDto sqlDaoParmGenDto : sqlDaoParmGenDtos) {
			String out =
					"<result column=\"" + sqlDaoParmGenDto.getParm() + "\" property=\"" + sqlDaoParmGenDto
							.getParmFormat() + "\" jdbcType=\"" + sqlDaoParmGenDto.getJdbcType() + "\"/>";
			System.out.println(out);
		}
		System.out.println();

		for (SqlDaoParmGenDto sqlDaoParmGenDto : sqlDaoParmGenDtos) {
			System.out.println(sqlDaoParmGenDto.getParm());
		}

		System.out.println();

		for (SqlDaoParmGenDto sqlDaoParmGenDto : sqlDaoParmGenDtos) {
			String out = "";
			if (sqlDaoParmGenDto.getJdbcType().equals("VARCHAR")) {
				out = "<if test=\" " + dtoName + sqlDaoParmGenDto.getParmFormat() + " != null and " + dtoName
						+ sqlDaoParmGenDto.getParmFormat() + " != ''\">\n"
						+ "      AND " + sqlDaoParmGenDto.getParm() + " =#{" + dtoName + sqlDaoParmGenDto
						.getParmFormat() + "}\n"
						+ "</if>";
			} else {
				out = "<if test=\" " + dtoName + sqlDaoParmGenDto.getParmFormat() + " != null\">\n"
						+ "      AND " + sqlDaoParmGenDto.getParm() + " =#{" + dtoName + sqlDaoParmGenDto
						.getParmFormat() + "}\n"
						+ "</if>";
			}

			System.out.println(out);
		}

	}


}
