import java.util.Scanner;

public class Main {
    public static Scanner lea = new Scanner(System.in);
    public static void main(String[] args) {
        boolean salir = false, grafoCreado = false;
        String ingresoOpcion;
        String vertices;
        String aristas;
        int numVertices, numAristas;
        char origen;
        Grafos grafo = new Grafos(0, 0);
        while (!salir) {
            Menu();
            System.out.println("Ingrese la opcion que desea realizar (1-14): ");
            ingresoOpcion = lea.next();
            if (!grafoCreado){
                ingresoOpcion = validarGrafoExiste(ingresoOpcion);
                grafoCreado = true;
            }
            switch (ingresoOpcion) {
                case "1":
                    System.out.println("Ingrese la informacion del grafo siguiendo el siguiente formato de vertices y aristas: ");
                    System.out.println("Ingrese el los Vertices del Grafo V = A,B,C,....: ");
                    vertices = lea.next();
                    vertices = vertices.toUpperCase();
                    vertices = ReplaceVertices(vertices);
                    vertices = EliminarVerticesRepetidos(vertices);
                    numVertices = ContarVertices(vertices);
                    System.out.println("Se enumeraran las aristas en el orden que se ingresen. ");
                    System.out.println("Ingrese las Aristas del Grafo E = (A,B,PesoArista);(B,C,PesoArista);....:");
                    aristas = lea.next();
                    aristas = aristas.toUpperCase();
                    aristas = ReplaceAristas(aristas);
                    numAristas = ContarAristas(aristas);
                    grafo = new Grafos(numVertices, numAristas);
                    grafo.CrearGrafo(vertices, aristas);
                    break;
                case "2":
                    System.out.println("Lista de Adyacencia: -> Vertice (Numero de la arista) (Peso de la arista) -> ");
                    grafo.ImprimirListaAdyacencia();
                    break;
                case "3":
                    grafo.LlenarMatrizAdyacencia();
                    grafo.ImprimirMatrizAdyacencia();
                    break;
                case "4":
                    grafo.LlenarMatrizIncidencia();
                    grafo.ImprimirMatrizIncidencia();
                    break;
                case "5":
                    System.out.println("Recorrido en Profundidad (DFS): ");
                    System.out.println("Ingrese el nodo de origen: ");
                    origen = lea.next().toUpperCase().charAt(0);
                    if (grafo.VerticeInexistente(origen)){
                        System.out.println("El nodo ingresado no existe en el grafo");
                        break;
                    }
                    grafo.DFS(origen);
                    System.out.print("\n");
                    break;
                case "6":
                    System.out.println("Recorrido en Amplitud (BFS): ");
                    System.out.println("Ingrese el nodo de origen: ");
                    origen = lea.next().toUpperCase().charAt(0);
                    if (grafo.VerticeInexistente(origen)){
                        System.out.println("El nodo ingresado no existe en el grafo");
                        break;
                    }
                    grafo.BFS(origen);
                    System.out.print("\n");
                    break;
                case "7":
                    System.out.println("Distancia mas corta/Distancia Alternativa (Dijkstra): ");
                    System.out.println("Ingrese el nodo de origen: ");
                    origen = lea.next().toUpperCase().charAt(0);
                    if (grafo.VerticeInexistente(origen)){
                        System.out.println("El nodo ingresado no existe en el grafo");
                        break;
                    }
                    grafo.DistanciaMinima(origen);
                    break;
                case "8":

                    break;
                case "9":

                    break;
                case "10":

                    break;
                case "11":

                    break;
                case "12":

                    break;
                case "13":

                    break;
                case "14":

                    break;
                case "15":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    private static int ContarVertices(String vertices) {
        int numVertices = 0;
        for (int i = 0; i < vertices.length(); i++) {
            if (vertices.charAt(i) != ',') {
                numVertices++;
            }
        }
        return numVertices;
    }

    private static String validarGrafoExiste(String ingresoOpcion) {
        while (!ingresoOpcion.equals("1") && !ingresoOpcion.equals("15")) {
            System.out.println("Primero debe crear el grafo");
            ingresoOpcion = lea.next();
        }
        return ingresoOpcion;
    }

    private static void Menu() {
        System.out.println("1. Crear el Grafo");
        System.out.println("2. Imprimir por lista de adyacencia");
        System.out.println("3. Imprimir por matriz de adyacencia");
        System.out.println("4. Imprimir por matriz de incidencia");
        System.out.println("5. Recorrido en profundidad (DFS)");
        System.out.println("6. Recorrido en amplitud (BFS)");
        System.out.println("7. Distancia mas corta/Distancia Alternativa (Dijkstra)");
        System.out.println("15. Salir");
    }

    private static String ReplaceVertices(String vertices) {
        vertices = vertices.replace("{", "");
        vertices = vertices.replace("}", "");
        vertices = vertices.replace(" ", "");
        if (vertices.charAt(vertices.length() - 1) == ';' || vertices.charAt(vertices.length() - 1) == ',') {
            vertices = vertices.substring(0, vertices.length() - 1);
        }
        return vertices;
    }

    private static String ReplaceAristas(String aristas) {
        aristas = aristas.replace("{", "");
        aristas = aristas.replace("}", "");
        aristas = aristas.replace(" ", "");
        aristas = aristas.replace("(", "");
        aristas = aristas.replace(")", "");
        if (aristas.charAt(aristas.length() - 1) == ';' || aristas.charAt(aristas.length() - 1) == ',') {
            aristas = aristas.substring(0, aristas.length() - 1);
        }
        return aristas;
    }

    private static String EliminarVerticesRepetidos(String vertices) {
        StringBuilder verticesSinRepetir = new StringBuilder();
        for (int i = 0; i < vertices.length(); i++) {
            if (vertices.charAt(i) != ',') {
                if (!verticesSinRepetir.toString().contains(vertices.charAt(i) + "")) {
                    verticesSinRepetir.append(vertices.charAt(i));
                }
            }
        }
        return verticesSinRepetir.toString();
    }

    private static int ContarAristas(String aristas) {
        int numAristas = 0;
        for (int i = 0; i < aristas.length(); i++) {
            if (aristas.charAt(i) == ';') {
                numAristas++;
            }
        }
        return (numAristas+1);
    }
}