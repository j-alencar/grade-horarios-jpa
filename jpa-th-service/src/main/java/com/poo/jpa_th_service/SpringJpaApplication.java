package com.poo.jpa_th_service;

import com.poo.jpa_th_service.entity.Aula;
import com.poo.jpa_th_service.entity.Curso;
import com.poo.jpa_th_service.entity.Disciplina;
import com.poo.jpa_th_service.entity.Professor;
import com.poo.jpa_th_service.entity.Sala;
import com.poo.jpa_th_service.entity.Turma;
import com.poo.jpa_th_service.repository.AulaRepository;
import com.poo.jpa_th_service.repository.CursoRepository;
import com.poo.jpa_th_service.repository.DisciplinaRepository;
import com.poo.jpa_th_service.repository.ProfessorRepository;
import com.poo.jpa_th_service.repository.SalaRepository;
import com.poo.jpa_th_service.repository.TurmaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class SpringJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository, TurmaRepository turmaRepository, AulaRepository aulaRepository, CursoRepository cursoRepository, SalaRepository salaRepository) {
		return (args) -> {
			// Parte "C" do CRUD

			log.info("Criando professores...");
			Professor walter = professorRepository.save(new Professor("Walter", false));
			Professor dornel = professorRepository.save(new Professor("Dornel", true));
			Professor gianinni = professorRepository.save(new Professor("Chaiene", true));
			Professor marcelo = professorRepository.save(new Professor("Rosalvo", false));
			Professor lucia = professorRepository.save(new Professor("Lucia", false));
			Professor leanderson = professorRepository.save(new Professor("Leanderson", false));
			for (Professor p : professorRepository.findAll()) {
				log.info(p.toString());
			}
			log.info("-------------------------------");

			Optional<Professor> p = professorRepository.findById(1L);
			Optional<Professor> p2 = professorRepository.findById(2L);
			Optional<Professor> p3 = professorRepository.findById(3L);
			Optional<Professor> p4 = professorRepository.findById(4L);
			Optional<Professor> p5 = professorRepository.findById(5L);
			Optional<Professor> p6 = professorRepository.findById(6L);
			log.info("-------------------------------");

			log.info("Criando disciplinas...");
			Disciplina alpc = disciplinaRepository.save(new Disciplina("ALPC", p.get()));
			Disciplina bdi = disciplinaRepository.save(new Disciplina("BDI", p2.get()));
			Disciplina erps = disciplinaRepository.save(new Disciplina("ERPS", p3.get()));
			Disciplina fgsi = disciplinaRepository.save(new Disciplina("FGSI", p4.get()));
			Disciplina mad = disciplinaRepository.save(new Disciplina("MAD", p5.get()));
			Disciplina pooii = disciplinaRepository.save(new Disciplina("POOII", p6.get()));
			for (Disciplina d : disciplinaRepository.findAll()) {
				log.info(d.toString());
			}

			Optional<Disciplina> d =  disciplinaRepository.findById(1L);
			Optional<Disciplina> d2 = disciplinaRepository.findById(2L);
			Optional<Disciplina> d3 = disciplinaRepository.findById(3L);
			Optional<Disciplina> d4 = disciplinaRepository.findById(4L);
			Optional<Disciplina> d5 = disciplinaRepository.findById(5L);
			Optional<Disciplina> d6 = disciplinaRepository.findById(6L);
			log.info("-------------------------------");

			log.info("Criando turmas...");
			Turma turma1441BN = turmaRepository.save(new Turma("144-1BN", new HashSet<>(Arrays.asList(d.get(), d5.get()))));
			Turma turma1442AN = turmaRepository.save(new Turma("144-2AN", new HashSet<>(Arrays.asList(d2.get(), d3.get()))));
			Turma turma1444AN = turmaRepository.save(new Turma("144-4AN", new HashSet<>(Arrays.asList(d4.get(), d6.get()))));
			for (Turma t : turmaRepository.findAll()) {
				log.info(t.toString());
			}

			Optional<Turma> t =  turmaRepository.findById(1L);
			Optional<Turma> t2 = turmaRepository.findById(2L);
			Optional<Turma> t3 = turmaRepository.findById(3L);
			log.info("-------------------------------");

			log.info("Criando aulas...");
			Aula aula1 = aulaRepository.save(new Aula("18:55", "29/04", "C325", d.get(), p.get(), t.get()));
			Aula aula2 = aulaRepository.save(new Aula("20:55", "29/04", "C320", d5.get(), p5.get(), t.get()));
			Aula aula3 = aulaRepository.save(new Aula("18:55", "29/04", "C325", d3.get(), p3.get(), t2.get()));
			Aula aula4 = aulaRepository.save(new Aula("20:55", "29/04", "C320", d2.get(), p2.get(), t2.get()));
			Aula aula5 = aulaRepository.save(new Aula("18:55", "29/04", "C114", d4.get(), p4.get(), t3.get()));
			Aula aula6 = aulaRepository.save(new Aula("20:55", "29/04", "C330", d6.get(), p6.get(), t3.get()));
			log.info("-------------------------------");

			log.info("Criando salas...");
			Sala sala1 = salaRepository.save(new Sala("C325", aula1));
			Sala sala2 = salaRepository.save(new Sala("C320", aula2));
			Sala sala3 = salaRepository.save(new Sala("C325", aula3));
			Sala sala4 = salaRepository.save(new Sala("C320", aula4));
			Sala sala5 = salaRepository.save(new Sala("C114", aula5));
			Sala sala6 = salaRepository.save(new Sala("C330", aula6));
			for (Sala s : salaRepository.findAll()) {
				log.info(s.toString());
			}
			log.info("-------------------------------");

			log.info("Criando cursos...");
			Curso sistemasInformacao = new Curso("BSI");
			sistemasInformacao.getDisciplinas().add(alpc);
			sistemasInformacao.getDisciplinas().add(bdi);
			sistemasInformacao.getDisciplinas().add(mad);
			sistemasInformacao.getDisciplinas().add(pooii);
			sistemasInformacao.getDisciplinas().add(fgsi);
			cursoRepository.save(sistemasInformacao);

			Curso engenhariaSoftware = new Curso("BES");
			engenhariaSoftware.getDisciplinas().add(alpc);
			engenhariaSoftware.getDisciplinas().add(bdi);
			engenhariaSoftware.getDisciplinas().add(mad);
			engenhariaSoftware.getDisciplinas().add(pooii);
			engenhariaSoftware.getDisciplinas().add(erps);
			cursoRepository.save(engenhariaSoftware);

			for (Curso c : cursoRepository.findAll()) {
				log.info(c.toString());
				for (Disciplina disc : c.getDisciplinas()) {
					log.info("Disciplina: " + disc.getNome());
				}
			}

			// Parte "R" do CRUD
			log.info("-------------------------------");
			log.info("Planejamento de aulas (a parte que importa!):");
			for (Aula a : aulaRepository.findAll()) {
				log.info(a.toString());
			}
			log.info("-------------------------------");
			log.info("Agora queries condicionais:");
			log.info("-------------------------------");
			log.info("Aulas de ALPC:");
			List<Aula> aulasByDisciplina = aulaRepository.findAllByDisciplina(d.get());
			for (Aula aula : aulasByDisciplina) {
				log.info(aula.toString());
			}
			log.info("-------------------------------");
			log.info("Aulas do professor Dornel:");
			List<Aula> aulasByProfessor = aulaRepository.findAllByProfessor(p2.get());
			for (Aula aula : aulasByProfessor) {
				log.info(aula.toString());
			}
			log.info("-------------------------------");
			log.info("Aulas da turma 144-4AN:");
			List<Aula> aulasByTurma = aulaRepository.findAllByTurma(t3.get());
			for (Aula aula : aulasByTurma) {
				log.info(aula.toString());
			}
		};
	}
}
