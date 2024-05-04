package com.poo.springjpademo;

import com.poo.springjpademo.entity.Aula;
import com.poo.springjpademo.entity.Disciplina;
import com.poo.springjpademo.entity.Professor;
import com.poo.springjpademo.entity.Turma;
import com.poo.springjpademo.repository.AulaRepository;
import com.poo.springjpademo.repository.DisciplinaRepository;
import com.poo.springjpademo.repository.ProfessorRepository;
import com.poo.springjpademo.repository.TurmaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.*;


@SpringBootApplication
public class SpringjpademoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringjpademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringjpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository, TurmaRepository turmaRepository, AulaRepository aulaRepository) {

		return (args) -> {
			//parte "C" do CRUD

			log.info("Criando professores...");
			Professor walter = professorRepository.save(new Professor("Walter", false));
			Professor dornel = professorRepository.save(new Professor("Dornel", true));
			Professor gianinni = professorRepository.save(new Professor("Gianinni", true));
			Professor marcelo = professorRepository.save(new Professor("Marcelo", false));
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
			Disciplina estcomp = disciplinaRepository.save(new Disciplina("ESTCOMP", p3.get()));
			Disciplina sop = disciplinaRepository.save(new Disciplina("SOP", p4.get()));
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
			//parte "R" do CRUD
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

