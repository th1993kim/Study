package api.product;

import core.product.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PatchMapping("/{seqProduct}")
    public ResponseEntity<Void> decreaseStock(@PathVariable("seqProduct") Long seqProduct) {
        productService.updateProductSharedLock(seqProduct);

        return ResponseEntity.noContent().build();
    }
}
