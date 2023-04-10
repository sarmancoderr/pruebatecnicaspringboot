package es.sarman.pruebatecnica.Heroes;

import es.sarman.pruebatecnica.Heroes.Exceptions.ExistingHeroException;
import es.sarman.pruebatecnica.Heroes.Exceptions.HeroNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class IHeroServiceImpl implements IHeroService {

    private final HeroRepository heroRepository;

    @Override
    public List<Hero> getHeroes() {
        log.info("Devolviendo listado de héroes");
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    public Hero createHero(HeroDTO heroDTO) {
        Hero hero = new Hero();
        hero.setName(heroDTO.getName());
        log.info("Creando heroe con nombre {}", hero.getName());
        return heroRepository.save(hero);
    }

    @Override
    public Hero getHero(int id) {
        log.info("Consiguiendo hero con id {}", id);
        return heroRepository.findById(id).orElseThrow(() -> new HeroNotFoundException());
    }

    @Override
    public List<Hero> searchHeroes(String query) {
        log.info("efectuando búsqueda con el texto {}", query);
        return heroRepository.findAllByNameIgnoreCaseContaining(query);
    }

    @Override
    public Hero updateHero(int id, HeroDTO update) {
        Optional<Hero> existingHero = heroRepository.findByName(update.getName());

        if (existingHero.isPresent()) {
            throw new ExistingHeroException();
        }

        Hero hero = heroRepository.findById(id).orElseThrow(() -> new HeroNotFoundException());

        log.info("Actualizando nombre de heroe con id {} a {}", id, update.getName());

        hero.setName(update.getName());
        return heroRepository.save(hero);
    }

    @Override
    public boolean removeHero(int id) {
        heroRepository.delete(
                heroRepository.findById(id).orElseThrow(() -> new HeroNotFoundException())
        );

        log.info("Hero con id {} eliminado", id);
        return true;
    }
}
