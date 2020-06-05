package subd.crud;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Materials;
import subd.repository.MaterialsRepository;

public class MaterialsCrud {
    public MaterialsRepository materialsRepository;

    public void createMaterials(Integer id , String name, Integer cost) {
        Materials materials = new Materials(id, name, cost);
        materialsRepository.save(materials);
    }
    public void readMaterials() {
        for ( Materials materials:materialsRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(materials);
        }
    }
    public void deleteOrders() {
        materialsRepository.deleteById(1);
    }
    public void updateMaterials(Integer id , String name, Integer cost) {
        Materials materials = new Materials(id, name, cost);
        materialsRepository.save(materials);
    }
}
