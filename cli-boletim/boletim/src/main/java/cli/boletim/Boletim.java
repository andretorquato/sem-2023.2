package boletim;

import java.util.ArrayList;
import java.util.List;

class Boletim {
	private int id;
	private String nome;
	private String frequenciaAtualizacao;
	private String categoria;
	private List<Post> posts;

	public Boletim(int id, String nome, String frequenciaAtualizacao, String categoria) {
		this.id = id;
		this.nome = nome;
		this.frequenciaAtualizacao = frequenciaAtualizacao;
		this.categoria = categoria;
		this.posts = new ArrayList<>();
	}

	public void adicionarPost(Post post) {
		posts.add(post);
	}

	public void removerPost(Post post) {
		posts.remove(post);
	}

	public void editarPost(Post post, String novoConteudo) {
		post.setConteudo(novoConteudo);
	}

	public void listarPosts() {
		for (Post post : posts) {
			System.out.println("ID do Post: " + post.getId());
			System.out.println("Conteúdo do Post: " + post.getConteudo());
		}
	}

	public void mostrarFrequenciaAtualizacao() {
		System.out.println("Frequência de Atualização: " + frequenciaAtualizacao);
	}

	public void mostrarCategoria() {
		System.out.println("Categoria: " + categoria);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getFrequenciaAtualizacao() {
		return frequenciaAtualizacao;
	}

	public String getCategoria() {
		return categoria;
	}
}