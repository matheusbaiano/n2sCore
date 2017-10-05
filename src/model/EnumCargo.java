package model;

public enum EnumCargo {
	
	PROFESSOR("Professor"), SECRETARIO("Secretário"), FUNCIONARIO("Funcionário");

	public String cargo;

	EnumCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}
	
	public static EnumCargo getByString(String value){
		switch (value) {
		case "Professor":
			return EnumCargo.PROFESSOR;
			
		case "Secretário":
			return EnumCargo.SECRETARIO;
			
		case "Funcionário":
			return EnumCargo.FUNCIONARIO;
		

		default:
			return null;
			
		}
	}
}