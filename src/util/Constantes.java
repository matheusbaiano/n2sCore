package util;

public class Constantes {

	private static String APP_URL;
	private static String ADM_URL;
	private static String APP_ASSETS_URL;
	private static String APP_JS_URL;
	private static String APP_IMG_URL;
	private static String APP_CSS_URL;
	private static Integer NUMBER_OF_ROWS_PER_PAGE;
	private static String SESSION_MSG;
	private static String DATABASE_CONF_DIR;
	private static String EMAIL_CONF_DIR;
	private static String MODULES_IMAGES_DIR;
	private static String USER_PROFILE_IMAGES_DIR;
	private static String USER_PROFILE_NONE_IMAGE_DIR;
	private static String APP_IMG_USER_DIR;
	private Constantes() {
		//
	}

	static {
		DATABASE_CONF_DIR = "C:\\n2s\\bd.txt";
		EMAIL_CONF_DIR = "C:\\n2s\\email.txt";
		APP_URL = "/Controle_de_Acesso";
		ADM_URL = APP_URL + "/view/adm";
		APP_ASSETS_URL = APP_URL + "/assets2";
		APP_JS_URL = APP_ASSETS_URL + "/js";
		APP_IMG_URL = APP_ASSETS_URL + "/img";
		APP_IMG_USER_DIR ="C:\\n2s\\img\\";
		APP_CSS_URL = APP_ASSETS_URL + "/css";
		NUMBER_OF_ROWS_PER_PAGE = 20;
		SESSION_MSG = "msg";
		MODULES_IMAGES_DIR = "C:\\imagens\\modulo";
		USER_PROFILE_IMAGES_DIR = "C:\\imagens\\usuario";
		USER_PROFILE_NONE_IMAGE_DIR = "C:\\imagens\\usuario\\none.png";
	}

	/**
	 * @return the appUrl
	 */
	public static String getAppUrl() {
		return APP_URL;
	}

	/**
	 * @return the admUrl
	 */
	public static String getAdmUrl() {
		return ADM_URL;
	}

	/**
	 * @return the appAssetsUrl
	 */
	public static String getAppAssetsUrl() {
		return APP_ASSETS_URL;
	}

	/**
	 * @return the appJsUrl
	 */
	public static String getAppJsUrl() {
		return APP_JS_URL;
	}

	/**
	 * @return the appImgUrl
	 */
	public static String getAppImgUrl() {
		return APP_IMG_URL;
	}

	/**
	 * @return the appCssUrl
	 */
	public static String getAppCssUrl() {
		return APP_CSS_URL;
	}

	/**
	 * @return the numberOfRowsPerPage
	 */
	public static Integer getNumberOfRowsPerPage() {
		return NUMBER_OF_ROWS_PER_PAGE;
	}

	/**
	 * @return the sessionMsg
	 */
	public static String getSessionMsg() {
		return SESSION_MSG;
	}

	/**
	 * @return the databaseConfDir
	 */
	public static String getDatabaseConfDir() {
		return DATABASE_CONF_DIR;
	}

	/**
	 * @return the emailConfDir
	 */
	public static String getEmailConfDir() {
		return EMAIL_CONF_DIR;
	}

	/**
	 * @return the mODULES_IMAGES_DIR
	 */
	public static String getMODULES_IMAGES_DIR() {
		return MODULES_IMAGES_DIR;
	}

	/**
	 * @param mODULES_IMAGES_DIR
	 *            the mODULES_IMAGES_DIR to set
	 */
	public static void setMODULES_IMAGES_DIR(String mODULES_IMAGES_DIR) {
		MODULES_IMAGES_DIR = mODULES_IMAGES_DIR;
	}

	/**
	 * @return the uSER_PROFILE_IMAGES_DIR
	 */
	public static String getUSER_PROFILE_IMAGES_DIR() {
		return USER_PROFILE_IMAGES_DIR;
	}

	/**
	 * @param uSER_PROFILE_IMAGES_DIR
	 *            the uSER_PROFILE_IMAGES_DIR to set
	 */
	public static void setUSER_PROFILE_IMAGES_DIR(String uSER_PROFILE_IMAGES_DIR) {
		USER_PROFILE_IMAGES_DIR = uSER_PROFILE_IMAGES_DIR;
	}

	/**
	 * @return the uSER_PROFILE_NONE_IMAGE_DIR
	 */
	public static String getUSER_PROFILE_NONE_IMAGE_DIR() {
		return USER_PROFILE_NONE_IMAGE_DIR;
	}

	/**
	 * @param uSER_PROFILE_NONE_IMAGE_DIR
	 *            the uSER_PROFILE_NONE_IMAGE_DIR to set
	 */
	public static void setUSER_PROFILE_NONE_IMAGE_DIR(String uSER_PROFILE_NONE_IMAGE_DIR) {
		USER_PROFILE_NONE_IMAGE_DIR = uSER_PROFILE_NONE_IMAGE_DIR;
	}

	public static String getAppImgUserDir() {
		return APP_IMG_USER_DIR;
	}

	public static void setAppImgUserDir(String aPP_IMG_USER_DIR) {
		APP_IMG_USER_DIR = aPP_IMG_USER_DIR;
	}
}
