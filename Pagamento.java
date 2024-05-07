package br.com.fiap.main;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Freelancer;
import br.com.fiap.bean.Vendedor;
import br.com.fiap.bean.VigiaNoturno;

public class Pagamento {

	public static void main(String[] args) {
		
		String aux, nome, escolha = "sim";
		float valorHora;
		int opcao, resposta = 0;
		
		while(resposta == 0) {
			try {
				nome = JOptionPane.showInputDialog("Digite o seu nome: ");
				aux = JOptionPane.showInputDialog("Qual o valor da hora de trabalho?");
				valorHora = Float.parseFloat(aux);
				aux = JOptionPane.showInputDialog("Escolha o funcionario:"
						+ "\n(1) Vigia Noturno \n(2) Vendedor \n(3) Freelancer");
				opcao = Integer.parseInt(aux);
				
				switch(opcao) {
				case 1: 
					aux = JOptionPane.showInputDialog("Digite o valor do adicional noturno: ");
					float adicional = Float.parseFloat(aux);
					VigiaNoturno vg = new VigiaNoturno(nome, valorHora, adicional);
					JOptionPane.showMessageDialog(null, "Nome: " + vg.getNome()
					+ "\nSalario: R$ " + vg.calcularSalario(), "Infos", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2: 
					aux = JOptionPane.showInputDialog("Digite o valor da comissão: ");
					float comissao = Float.parseFloat(aux);
					Vendedor vd = new Vendedor(nome, valorHora, comissao);
					JOptionPane.showMessageDialog(null, "Nome: " + vd.getNome()
					+ "\nSalario: R$ " + vd.calcularSalario(), "Infos", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 3: 
					aux = JOptionPane.showInputDialog("Digite o número do CNPJ: ");
					long CNPJ = Long.parseLong(aux);
					Freelancer fl = new Freelancer(nome, valorHora, CNPJ);
					JOptionPane.showMessageDialog(null, "\nNome: " + fl.getNome()
					+ "\nSalario: R$ " + fl.calcularSalario(), "Infos", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					throw new Exception("Escolha incorreta!");
				}
				resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar? ", "Atenção", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Fim do programa!", "Alerta", JOptionPane.WARNING_MESSAGE);

	}

}
