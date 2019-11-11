package com.test.sqlgendao;


import java.util.ArrayList;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/3/26
 */
public class SqlGenDaoUpdate {

	private final static boolean isAllString = false;


	private final static String sqlString = "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',\n"
			+ "  `member_id` bigint(20) NOT NULL COMMENT '商户ID',\n"
			+ "  `company_code` varchar(30) NOT NULL COMMENT '企业编码',\n"
			+ "  `card_no` varchar(128) NOT NULL COMMENT '银行卡号',\n"
			+ "  `card_name` varchar(128) NOT NULL COMMENT '银行卡名称',\n"
			+ "  `id_card_no` varchar(128) DEFAULT '' COMMENT '身份证',\n"
			+ "  `mobile` varchar(128) DEFAULT '' COMMENT '手机号',\n"
			+ "  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1启用 0禁用',\n"
			+ "  `rem1` varchar(200) DEFAULT '' COMMENT '预留字段1',\n"
			+ "  `rem2` varchar(200) DEFAULT '' COMMENT '预留字段2',\n"
			+ "  `rem3` varchar(200) DEFAULT '' COMMENT '预留字段3',\n"
			+ "  `created_by` varchar(32) NOT NULL DEFAULT 'auto' COMMENT '创建人',\n"
			+ "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n"
			+ "  `updated_by` varchar(32) DEFAULT NULL COMMENT '最后更新人',\n"
			+ "  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',";

	private static String dtoName = "";

	public static void main(String[] args) {
		String[] fields = sqlString.split(",\n");
		ArrayList<SqlDaoParmGenDto> sqlDaoParmGenDtos = new ArrayList<>();
		ArrayList<SqlDaoParmGenDto> sqlDaoParmGenDtos2 = new ArrayList<>();
		for (String field : fields) {
			field = field.replaceAll("`", "");
			field = field.replaceAll("\\s+", " ");
			sqlDaoParmGenDtos.add(new SqlDaoParmGenDto().bulid(field, false));
			sqlDaoParmGenDtos2.add(new SqlDaoParmGenDto().bulid(field, true));
		}

		for (SqlDaoParmGenDto sqlDaoParmGenDto2 : sqlDaoParmGenDtos2) {
			String out = "private " + sqlDaoParmGenDto2.getType() + " " + sqlDaoParmGenDto2.getParmFormat() + ";";
			System.out.println("//" + sqlDaoParmGenDto2.getComment());
			System.out.println(out);
			System.out.println();
		}
		System.out.println();
		System.out.println();

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
