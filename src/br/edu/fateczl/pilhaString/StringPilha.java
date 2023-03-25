/*
RESUMO      : Construção de uma pilha tipo string
PROGRAMADORA: Luiza Felix
DATA        : 25/03/2023
 */

package br.edu.fateczl.pilhaString;

public class StringPilha {
	StringNo topo; //declarei que o topo é uma variável tipo nó
	
	public StringPilha() {
//		para a criação do nó 0 (null), padrão de todas as instanciações da classe
		topo = null;
	}
	
	public boolean vazia() {
		if(topo == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void push(String txt) {
		StringNo novo = new StringNo();
		novo.dado = txt;

		if (vazia()) { 
			topo = novo;
		} else {
			novo.anterior = topo; // referencio o topo anteiror
			topo = novo; // declaro meu novo topo como o valor "pushado"
		}
	}

	public String pop() throws Exception {
		if (vazia()) {
			throw new Exception("Não há elementos para desempilhar!");
		}
		String valor = topo.dado; //valor que vai sair da pilha
		topo = topo.anterior; // meu topo agora é o que vinha antes desse.

		return valor;
		// o valor que estou removendo da pilha será devolvido para o código principal
	}
	
	public String top() throws Exception {
		//visualizar o TOPO da pilha
		if (vazia()) {
			throw new Exception("Não há elementos para visualização!");
		}
		return topo.dado;
	}

	public int size() {
//		visualizo a quantidade de elementos empilhados, criando uma cópia da pilha e "destuindo" ela
		int i = 0;
		if (!vazia()) { //só conto se a pilha recebida não for vazia 
			StringNo aux = topo; 
			i = 1;
			while (aux.anterior != null) {
				//faço essa verificação de quantidade até que meu próximo endereço seja o "null", indicando que já passei por todas as casas existentes dentro da minha pilha
				i++;
				aux = aux.anterior;
			}
		}
		return i;
	}
	
	public String toString() {
		// conversor da pilha para leitura, acho válido manter esse para a visualização final da pilha
		StringBuffer buffer = new StringBuffer();
		StringNo aux = topo;
		int i = 0; 
		while (i < size()) { 
			buffer.append("	" + aux.dado);
			aux = aux.anterior;
			//a verificação é sempre tipo top-bottom
			i++;
		}
		return buffer.toString();
	}
		
}


