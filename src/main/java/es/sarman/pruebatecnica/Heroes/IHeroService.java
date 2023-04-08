package es.sarman.pruebatecnica.Heroes;

import org.springframework.stereotype.Service;

import java.util.List;

public interface IHeroService {

    List<Hero> getHeroes();

    Hero createHero(HeroDTO heroDTO);

    Hero getHero(int id);

    List<Hero> searchHeroes(String query);

    Hero updateHero(int id, HeroDTO update);

    boolean removeHero(int id);

}
