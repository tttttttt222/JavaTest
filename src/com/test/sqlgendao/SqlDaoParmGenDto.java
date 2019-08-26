package com.test.sqlgendao;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/8/26
 */
public class SqlDaoParmGenDto {

	//类型
	private String type;
	//
	private String brief;
	//字段
	private String parm;
	//JDBC类型
	private String jdbcType;
	//字段类型
	private String parmFormat;
	//备注
	private String comment;

	private String field;

	private boolean isAllString = false;


	public SqlDaoParmGenDto bulid(String field, boolean isAllString) {
		this.isAllString = isAllString;
		this.field = field;
		this.brief = getBrief(field);
		this.parm = getParmWithoutBlank(field);
//		this.parmWithoutBlank = getParmWithoutBlank(field);
		this.type = getType(brief, isAllString);
		this.jdbcType = getJDBCType(brief, isAllString);
		this.comment = getComment(brief);
		this.parmFormat = transSybParm(parm);
		return this;
	}


	private String transSybParm(String parm) {
		while (parm.indexOf("_") != -1) {
			int pin = parm.indexOf("_");
			parm = parm.substring(0, pin) + parm.substring(pin + 1, pin + 2).toUpperCase() + parm
					.substring(pin + 2);
		}
		return parm;
	}

	private String getComment(String brief) {
		int start = brief.indexOf("COMMENT");
		if (start == -1) {
			return "";
		}
		start = brief.indexOf("'", start);
		int end = brief.indexOf("'", start + 1);
		String comment = brief.substring(start + 1, end);
		return comment;
	}

	private String getJDBCType(String brief, boolean isAllString) {
		if (isAllString) {
			return "VARCHAR";
		} else {
			int end = brief.indexOf("(");
			int start = brief.indexOf(" ", 1);
			if (end == -1) {
				end = brief.indexOf(" ", start + 1);
			}
			String substring = brief.substring(start + 1, end);
			switch (substring) {
				case "bigint":
					return "BIGINT";
				case "varchar":
					return "VARCHAR";
				case "tinyint":
					return "TINYINT";
				case "int":
					return "Integer";
				case "timestamp":
					return "TIMESTAMP";
				case "decimal":
					return "DECIMAL";
				default:
					return "VARCHAR";
			}
		}
	}

	private String getParmWithoutBlank(String field) {
		int i = field.indexOf(" ", 1);
		String parm = field.substring(0, i);
		return parm.trim();
	}

	private String getParm(String field) {
		int i = field.indexOf(" ", 1);
		String parm = field.substring(0, i);
		return parm;
	}

	private String getBrief(String field) {
		int i = field.indexOf(" ", 1);
		String brief = "//" + field.substring(i);
		return brief;
	}


	private String getType(String brief, boolean isAllString) {
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
				case "int":
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


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getParm() {
		return parm;
	}

	public void setParm(String parm) {
		this.parm = parm;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getParmFormat() {
		return parmFormat;
	}

	public void setParmFormat(String parmFormat) {
		this.parmFormat = parmFormat;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}


}
