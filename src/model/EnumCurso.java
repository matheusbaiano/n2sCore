package model;

public enum EnumCurso {

	CIENCIADACOMPUTACAO(1), ENGENHARIACIVIL(2), ENGENHARIADEPRODUCAO(3), ENGENHARIADESOFTWARE(4), ENGENHARIAMECANINCA(5);

	public int valorCurso;

	EnumCurso(int valor) {
		valorCurso = valor;
	}

	public int getValorCurso() {
		return valorCurso;
	}
	
	
	public static String value(Integer valor){
		switch(valor){
		case 1:
			return "Ciência da Computação";
		case 2:
			return "Engenharia Civil";
		case 3:
			return "Engenharia de Produção";
		case 4:
			return "Engenharia de Software";
		case 5:
			return "Engenharia Mecânica";
		default:
			return "";
		}
	
	}
	
	
	
}