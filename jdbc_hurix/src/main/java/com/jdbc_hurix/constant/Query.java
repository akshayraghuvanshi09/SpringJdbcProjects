package com.jdbc_hurix.constant;

public class Query {
	public static final String languageList = "SELECT * FROM cloudcore.language";

	public static final String insertLanguage = "insert into cloudcore.language (LANGUAGE,LOCALE) values(?,?)";

	public static final String updateLanguageById = "UPDATE cloudcore.language SET LANGUAGE = ?, LOCALE= ? "
			+ "WHERE id = ?";

	public static final String deleteLanguageById = "DELETE FROM cloudcore.language WHERE id=?";

	public static final String saveStep="INSERT INTO cloudcore.step  (kitaboo_id,level_of_support,package_id,ref_id,title,type) VALUES (?,?,?,?,?,?)";

	public static final String saveInstructions="INSERT INTO cloudcore.step_instructions \n" +
			" (language,student,teacher,step_id) VALUES (?,?,?,?)";

	public static final String saveMetaData="INSERT INTO cloudcore.step_metadata \n" +
			" (course,description,keywords,language,level_of_support,search_skills,show_feedback,show_result,theme,step_id) VALUES (?,?,?,?,?,?,?,?,?,?)";

	public static final String saveMetaData1="INSERT INTO cloudcore.step_metadata \n" +
			" (course,step_id) VALUES (?,?)";

	public static final String getLastIndexId="select last_insert_id()";

	public static final String getStepById="select s.kitaboo_id ,s.level_of_support,s.package_id,s.ref_id,s.title ,s.type,st.language,st.student ,st.teacher,sp.course,sp.description,sp.keywords,sp.language,\n" +
			"sp.level_of_support,sp.search_skills,sp.show_feedback,sp.show_result,sp.theme\n" +
			" from step s,step_instructions st ,step_metadata sp where s.id = st.step_id and s.id=sp.step_id and s.id =?";

	public static final String countByRefId="SELECT count(id) FROM cloudcore.step where ref_id=?";

	public static final String countByKitabooId="SELECT count(id) FROM cloudcore.step where kitaboo_id=?";

}
