package com.luna.rdd.util.salvacion;

public class TiradaSalvacion {

	public Long calculaTiradaSalvacion(Long puntuacionCaracteristica) {
		switch (puntuacionCaracteristica.intValue()) {
			case 1:
				return Long.valueOf(-5);
			case 2:
			case 3:
				return Long.valueOf(-4);
			case 4:
			case 5:
				return Long.valueOf(-3);
			case 6:
			case 7:
				return Long.valueOf(-2);
			case 8:
			case 9:
				return Long.valueOf(-1);
			case 10:
			case 11:
				return Long.valueOf(0);
			case 12:
			case 13:
				return Long.valueOf(1);
			case 14:
			case 15:
				return Long.valueOf(2);
			case 16:
			case 17:
				return Long.valueOf(3);
			case 18:
			case 19:
				return Long.valueOf(4);
			case 20:
			case 21:
				return Long.valueOf(5);
			case 22:
			case 23:
				return Long.valueOf(6);
			case 24:
			case 25:
				return Long.valueOf(7);
			case 26:
			case 27:
				return Long.valueOf(8);
			case 28:
			case 29:
				return Long.valueOf(9);
			case 30:
				return Long.valueOf(10);
				
			default:
				return Long.valueOf(0);
			
		}
	}
}
