package com.test.sqlgendao;


import java.util.ArrayList;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/3/26
 */
public class SqlGenDaoUpdate {

	private final static boolean isAllString = false;


	private final static String sqlString = "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n"
			+ "  `goods_name` varchar(255) DEFAULT NULL,\n"
			+ "  `goods_price` decimal(10,2) DEFAULT NULL,\n"
			+ "  `goods_number` int(11) DEFAULT NULL,\n"
			+ "  `goods_weight` decimal(10,0) DEFAULT NULL,\n"
			+ "  `goods_state` tinyint(4) DEFAULT NULL,\n"
			+ "  `hot_mumber` int(11) DEFAULT NULL,\n"
			+ "  `is_promote` tinyint(4) DEFAULT NULL,\n"
			+ "  `goods_small_logo` varchar(255) DEFAULT NULL,\n"
			+ "  `goods_big_logo` varchar(255) DEFAULT NULL,\n"
			+ "  `goods_introduce` text ,\n"
			+ "  `is_del` tinyint(4) DEFAULT NULL,\n"
			+ "  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,\n"
			+ "  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n"
			+ "  `delete_time` timestamp NULL DEFAULT NULL,";

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

		System.out.println("--------------------------------------query----------------------------------------------");

		for (SqlDaoParmGenDto sqlDaoParmGenDto : sqlDaoParmGenDtos) {
			String out = "";
			if (sqlDaoParmGenDto.getJdbcType().equals("VARCHAR")) {
				out = "<if test=\" XXX." + dtoName + sqlDaoParmGenDto.getParmFormat() + " != null and XXX." + dtoName
						+ sqlDaoParmGenDto.getParmFormat() + " != ''\">\n"
						+ "      AND " + sqlDaoParmGenDto.getParm() + " =#{XXX." + dtoName + sqlDaoParmGenDto
						.getParmFormat() + "}\n"
						+ "</if>";
			} else {
				out = "<if test=\" XXX." + dtoName + sqlDaoParmGenDto.getParmFormat() + " != null\">\n"
						+ "      AND " + sqlDaoParmGenDto.getParm() + " =#{XXX." + dtoName + sqlDaoParmGenDto
						.getParmFormat() + "}\n"
						+ "</if>";
			}

			System.out.println(out);
		}

		System.out.println("--------------------------------------update----------------------------------------------");

		for (SqlDaoParmGenDto sqlDaoParmGenDto : sqlDaoParmGenDtos) {
			String out = "";
			if (sqlDaoParmGenDto.getJdbcType().equals("VARCHAR")) {
				out = "<if test=\" XXX." + dtoName + sqlDaoParmGenDto.getParmFormat() + " != null and XXX." + dtoName
						+ sqlDaoParmGenDto.getParmFormat() + " != ''\">\n"
						+ "      " + sqlDaoParmGenDto.getParm() + " =#{XXX." + dtoName + sqlDaoParmGenDto
						.getParmFormat() + "}\n"
						+ "</if>";
			} else {
				out = "<if test=\" XXX." + dtoName + sqlDaoParmGenDto.getParmFormat() + " != null\">\n"
						+ "      " + sqlDaoParmGenDto.getParm() + " =#{XXX." + dtoName + sqlDaoParmGenDto
						.getParmFormat() + "}\n"
						+ "</if>";
			}

			System.out.println(out);
		}

	}


}
