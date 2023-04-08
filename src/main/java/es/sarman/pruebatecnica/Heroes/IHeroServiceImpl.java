package es.sarman.pruebatecnica.Heroes;

import es.sarman.pruebatecnica.Heroes.Exceptions.ExistingHeroException;
import es.sarman.pruebatecnica.Heroes.Exceptions.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IHeroServiceImpl implements IHeroService {

    @Autowired HeroRepository heroRepository;

    @Override
    public List<Hero> getHeroes() {
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    public Hero createHero(HeroDTO heroDTO) {
        Hero hero = new Hero(heroDTO.getName());
        return heroRepository.save(hero);
    }

    @Override
    public Hero getHero(int id) {
        return heroRepository.findById(id).orElseThrow(() -> new HeroNotFoundException());
    }

    @Override
    public List<Hero> searchHeroes(String query) {
        return heroRepository.findAllByNameIgnoreCaseContaining(query);
    }

    @Override
    public Hero updateHero(int id, HeroDTO update) {
        Optional<Hero> existingHero = heroRepository.findByName(update.getName());

        if (existingHero.isPresent()) {
            throw new ExistingHeroException();
        }

        Hero hero = heroRepository.findById(id).orElseThrow(() -> new HeroNotFoundException());

        hero.setName(update.getName());
        return heroRepository.save(hero);
    }

    @Override
    public boolean removeHero(int id) {
        heroRepository.delete(
                heroRepository.findById(id).orElseThrow(() -> new HeroNotFoundException())
        );
        return true;
    }
}
