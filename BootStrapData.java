package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

if (partRepository.count() == 0) {
    OutsourcedPart o = new OutsourcedPart();
    o.setCompanyName("WeFurn");
    o.setName("Glass Table Top");
    o.setInv(5);
    o.setPrice(200.0);
    o.setId(1);
    o.setMinInv(0);
    o.setMaxInv(100);
    outsourcedPartRepository.save(o);
    OutsourcedPart thePart = null;

    InhousePart pillow = new InhousePart();
    pillow.setName("pillow");
    pillow.setInv(5);
    pillow.setPrice(200.0);
    pillow.setId(1);
    pillow.setMinInv(0);
    pillow.setMaxInv(100);
    inhousePartRepository.save(pillow);

    InhousePart table_leg = new InhousePart();
    table_leg.setName("table_leg");
    table_leg.setInv(5);
    table_leg.setPrice(200.0);
    table_leg.setId(1);
    table_leg.setMinInv(0);
    table_leg.setMaxInv(100);
    inhousePartRepository.save(table_leg);

    InhousePart screws = new InhousePart();
    screws.setName("screws");
    screws.setInv(5);
    screws.setPrice(200.0);
    screws.setId(1);
    screws.setMinInv(0);
    screws.setMaxInv(100);
    inhousePartRepository.save(screws);

    InhousePart bedframe = new InhousePart();
    bedframe.setName("bedframe");
    bedframe.setInv(5);
    bedframe.setPrice(200.0);
    bedframe.setId(1);
    bedframe.setMinInv(0);
    bedframe.setMaxInv(100);
    inhousePartRepository.save(bedframe);

    List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
    for (OutsourcedPart part : outsourcedParts) {
        if (part.getName().equals("out test")) thePart = part;
    }



    System.out.println(thePart.getCompanyName());
}
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
        if (productRepository.count() == 0) {

        Product sofa= new Product("sofa",500.0,15);
        Product bed= new Product("bed",500.0,15);
        Product table_set= new Product("table set",500.0,15);
        Product bookcase= new Product("bookcase",500.0,15);
        Product ottoman= new Product("ottoman",500.0,15);
        productRepository.save(sofa);
        productRepository.save(bed);
        productRepository.save(table_set);
        productRepository.save(bookcase);
        productRepository.save(ottoman);



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
    }
}
