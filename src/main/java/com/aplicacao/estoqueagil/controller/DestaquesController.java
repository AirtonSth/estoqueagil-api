package com.aplicacao.estoqueagil.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.dto.DestaquesDto;
import com.aplicacao.estoqueagil.dto.ProdutosDto;
import com.aplicacao.estoqueagil.model.Estoque;
import com.aplicacao.estoqueagil.model.Marca;
import com.aplicacao.estoqueagil.model.Modelo;
import com.aplicacao.estoqueagil.model.Produto;
import com.aplicacao.estoqueagil.repository.EstoqueRepository;
import com.aplicacao.estoqueagil.repository.MarcaRepository;
import com.aplicacao.estoqueagil.repository.ModeloRepository;
import com.aplicacao.estoqueagil.repository.MovimentoRepository;
import com.aplicacao.estoqueagil.repository.ProdutoRepository;
/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/destaques")
public class DestaquesController {
	
	@Autowired
	MovimentoRepository movimentoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	ModeloRepository modeloRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	@GetMapping("/")
	public DestaquesDto getDestaques(){
		List<ProdutosDto> listaProdutos = null;
		List<ProdutosDto> listaMarcasMaisVendidas = null;
		
		listaProdutos = getListaProdutos (1L);
		listaMarcasMaisVendidas = getListaMaisVendidos(listaProdutos);
		DestaquesDto destaquesDto = new DestaquesDto();
		destaquesDto.setMarcaDoMesCapinhaSaida(listaMarcasMaisVendidas.get(0).getMarcaProduto());
		destaquesDto.setModeloDoMesCapinhaSaida(listaProdutos.get(0).getMarcaProduto()+" - "+listaProdutos.get(0).getModeloProduto());
		
		listaProdutos = getListaProdutos (2L);
		listaMarcasMaisVendidas = getListaMaisVendidos(listaProdutos);
		destaquesDto.setMarcaDoMesPeliculaSaida(listaMarcasMaisVendidas.get(0).getMarcaProduto());
		destaquesDto.setModeloDoMesPeliculaSaida(listaProdutos.get(0).getMarcaProduto()+" - "+listaProdutos.get(0).getModeloProduto());
		
		destaquesDto.setFuncionarioDoMes("Airton");
		
		return destaquesDto;
	}
	
	public List<ProdutosDto> getListaProdutos(long tipoProduto) {
		
		List<ProdutosDto> listaProdutos = new ArrayList<ProdutosDto>();
		List<ProdutosDto> produtosTemp = new ArrayList<ProdutosDto>();
		
		List<Produto> produtos = produtoRepository.findByIdTipoProduto(tipoProduto);
		
		List<Estoque> estoque = new ArrayList<Estoque>();
		
		for(Produto p : produtos){
			//mudar para filtrar apenas o mes corrente
			estoque.addAll(estoqueRepository.findByQuantidadeNotNullAndIdProduto(p.getId()));
		}
		
		for(Estoque e : estoque){
			if(e.getIdProduto()!=null){
				ProdutosDto produtoDto = new ProdutosDto();
				ProdutosDto produtoTemp = new ProdutosDto();
				
				Produto produto = produtoRepository.getOne(e.getIdProduto());
				Modelo modelo = modeloRepository.getOne(produto.getIdModelo());
				Marca marca = marcaRepository.getOne(modelo.getIdMarca());
				
				produtoTemp.setModeloProduto(modelo.getDescricao());
				
				if(!produtosTemp.contains(produtoTemp)){
					
					
					produtoDto.setIdProduto(e.getIdProduto());
					produtoDto.setModeloProduto(modelo.getDescricao());
					produtoDto.setMarcaProduto(marca.getDescricao());
					produtoDto.setQuantidadeProduto(e.getQuantidade());
					
					listaProdutos.add(produtoDto);
				
					produtosTemp.add(produtoTemp);
				}else{
					for(ProdutosDto p : listaProdutos) {
						if(p.getModeloProduto().equals(produtoTemp.getModeloProduto())) {
							p.setQuantidadeProduto(p.getQuantidadeProduto()+e.getQuantidade());
						}
					}
				}
				
			}
		}
	
		Collections.sort(listaProdutos, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				ProdutosDto p1 = (ProdutosDto) o1;
				ProdutosDto p2 = (ProdutosDto) o2;
				return p1.getQuantidadeProduto() > p2.getQuantidadeProduto()? -1 : (p1.getQuantidadeProduto() < p1.getQuantidadeProduto() ? +1: 0);
			}
		});		
		return listaProdutos;
	}
	public List<ProdutosDto> getListaMaisVendidos(List<ProdutosDto> listaProdutos) {
		List<Marca> listaMarcas = new ArrayList<Marca>();
		listaMarcas = marcaRepository.findAll();
		
		List<ProdutosDto> listaMarcasMaisVendidas = new ArrayList<ProdutosDto>();
		for(Marca m: listaMarcas) {
			ProdutosDto p = new ProdutosDto();
			p.setMarcaProduto(m.getDescricao());
			listaMarcasMaisVendidas.add(p);
		}

		for(ProdutosDto t : listaMarcasMaisVendidas) {
			for(ProdutosDto p : listaProdutos) {
				if(t.getMarcaProduto().equalsIgnoreCase(p.getMarcaProduto())) {
					if(t.getQuantidadeProduto()==null) {
						t.setQuantidadeProduto(0L);
					}
					if(p.getQuantidadeProduto()==null) {
						p.setQuantidadeProduto(0L);
					}
					t.setQuantidadeProduto(t.getQuantidadeProduto()+p.getQuantidadeProduto());
				}
			}	
		}
		
		Collections.sort(listaMarcasMaisVendidas, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				ProdutosDto p1 = (ProdutosDto) o1;
				ProdutosDto p2 = (ProdutosDto) o2;
				return p1.getQuantidadeProduto() > p2.getQuantidadeProduto()? -1 : (p1.getQuantidadeProduto() < p1.getQuantidadeProduto() ? +1: 0);
			}
		});
		return listaMarcasMaisVendidas;
	}
	
}
