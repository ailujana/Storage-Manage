package modelo;


public class Main {
	static Filial f1,f2;
	static Bebida b1;
	static NaoPerecivel np1,np2;
	static Perecivel p1,p2;
	static DataValidade d1,d2;
	static Empresa e1;
	
	
    public static void main(String[] args) {
    	e1 = new Empresa("Frutaria Tudo da Roca", 6434114567L, "Avenida Joao Naves", "98. 007. 128/0001-34");
    	f1 = new Filial("Ethan Distribuidora", 61934000087L, "Quadra 102, Asa Sul", "88. 567. 678/0001-12","Bebidas");
    	f2 = new Filial("Verdurao do Ze", 61912345667L, "Quadra 304, Ceilandia", "65. 234. 020/0001-45","Verduras");
    	
    	d1 = new DataValidade(12,04,2024);
    	d2 = new DataValidade(13,12,2025);
    	
    	b1 = new Bebida("Coca-Cola", 7L,4.5f,f1,"Coca-Cola", 45L,d1);
    	
    	np1 = new NaoPerecivel("Acafrao", 2L, 40f,f2,"Po",d1);
    	
    	p1 = new Perecivel("Tomate", 4L,3f,f2,"Fruta",d2);
    	
    	System.out.println(e1.toString());
    	System.out.println(f1.toString());
    	System.out.println(f2.toString());
    	System.out.println(d1.toString());
    	System.out.println(d2.toString());
    	System.out.println(p1.toString());
    	System.out.println(np1.toString());
    	System.out.println(b1.toString());
    	
    	d2.setMes(04);
    	np1.setPreco(80f);
    	System.out.println(b1.getFilial());
    	f2.setNumTel(6112345678L);

    	System.out.println(f2.getNumTel());

    	System.out.println(d2.getMes());

    	System.out.println(np1.getPreco());
    	
    	
    }
}