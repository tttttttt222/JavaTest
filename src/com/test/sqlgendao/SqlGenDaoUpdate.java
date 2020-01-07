package com.test.sqlgendao;


import java.util.ArrayList;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/3/26
 */
public class SqlGenDaoUpdate {

	private final static boolean isAllString = false;


	private final static String sqlString = "  `id` bigint(11) NOT NULL AUTO_INCREMENT,\n"
			+ "  `member_id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '商户id',\n"
			+ "  `channel_member_id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '商户渠道方id',\n"
			+ "  `rsa_public_key` text COLLATE utf8mb4_bin COMMENT '公钥',\n"
			+ "  `rsa_private_key` text COLLATE utf8mb4_bin COMMENT '私钥',\n"
			+ "  `channel_id` int(16) NOT NULL COMMENT '渠道号:1 畅游',\n"
			+ "  `counter_id` int(16) DEFAULT NULL COMMENT '柜台号',\n"
			+ "  `options` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '转换积分渠道',\n"
			+ "  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,\n"
			+ "  `rem1` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,\n"
			+ "  `rem2` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,\n"
			+ "  `rem3` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,\n"
			+ "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n"
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
