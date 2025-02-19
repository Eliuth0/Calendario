import java.text.DecimalFormat;

public class Date {
    private int dia;
    private int mes;
    private int año;

    // Constructor por defecto
    public Date() {
        dia = 1;
        mes = 1;
        año = 1900;
    }

    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public String toFechaAbreviadaString() {
        DecimalFormat formateador = new DecimalFormat("00");
        return formateador.format(dia) + "/" + formateador.format(mes) + "/" + año;
    }

    // Setters
    public void setDia(int d) {
        int diasDelMes = diasMes(mes, año);
        if (d > 0 && d <= diasDelMes) {
            dia = d;
        } else {
            System.out.println(d + " no es un día válido");
            dia = 1;
        }
    }

    public void setMes(int m) {
        if (m > 0 && m <= 12) {
            mes = m;
            if (dia > diasMes(mes, año)) {
                dia = diasMes(mes, año);
            }
        } else {
            System.out.println(m + " no es un mes válido");
            mes = 1;
        }
    }

    public void setAnio(int a) {
        if (a >= 1900 && a <= 2025) {
            año = a;
        } else {
            System.out.println(a + " no es un año válido");
            año = 1900;
        }
    }

    // Función que identifica los días del mes
    private int diasMes(int m, int a) {
        int[] diasDelMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m == 2 && esBisiesto(a)) {
            return 29;
        }
        return diasDelMes[m];
    }

    // Función que identifica si un año es bisiesto
    private boolean esBisiesto(int a) {
        return a % 4 == 0 && (a % 100 != 0 || a % 400 == 0);
    }

    // Método para incrementar un día
    public void incrementarDia() {
        if (dia < diasMes(mes, año)) {
            dia++;
        } else {
            dia = 1;
            if (mes == 12) {
                mes = 1;
                año = 2025;
            } else {
                mes++;
            }
        }
    }

    // Método para incrementar un mes
    public void incrementarMes() {
        if (mes == 12) {
            mes = 1;
            año++;
        } else {
            mes++;
        }
        
        if (dia > diasMes(mes, año)) {
            dia = diasMes(mes, año);
        }
    }

    // Método de prueba
    public static void main(String[] args) {
        Date fecha = new Date();
        fecha.setDia(31);
        fecha.setMes(12);
        fecha.setAnio(2024);
        
        System.out.println("Fecha actual: " + fecha.toFechaAbreviadaString());
        fecha.incrementarDia();
        System.out.println("Después de incrementar un día: " + fecha.toFechaAbreviadaString());
        
        fecha.incrementarMes();
        System.out.println("Después de incrementar un mes: " + fecha.toFechaAbreviadaString());
    }
}
