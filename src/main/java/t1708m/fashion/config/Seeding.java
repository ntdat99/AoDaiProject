package t1708m.fashion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.Product;
import t1708m.fashion.entity.ProductCategory;
import t1708m.fashion.repository.AccountRepository;
import t1708m.fashion.repository.CategoryRepository;
import t1708m.fashion.repository.ProductRepository;

import java.util.logging.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Component
public class Seeding implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOGGER = Logger.getLogger(Seeding.class.getSimpleName());

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AccountRepository accountRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private List<Product> productList = new ArrayList<>();
    private List<ProductCategory> productCategoryList = new ArrayList<>();


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        LOGGER.log(Level.INFO, String.format("Start seeding..."));
        categoryRepository.disableForeignKeyCheck();
        seedingAccount();
        seedingCategory();
        seedingProduct();
        categoryRepository.enableForeignKeyCheck();
        LOGGER.log(Level.INFO, String.format("Seeding success!"));
    }

    void seedingAccount() {
        accountRepository.deleteAll();
        accountRepository.resetIncrement();

        Account account = new Account();
        account.setRole(Account.Role.ADMIN.getValue());
        account.setAddress("Hà Nội");
        account.setPhone("091234567");
        account.setUsername("admin");
        account.setEmail("admin@gmail.com");
        account.setStatus(Account.Status.ACTIVE.getValue());
        account.setPassword(passwordEncoder.encode("admin"));

        accountRepository.save(account);

        account = new Account();
        account.setRole(Account.Role.CUSTOMER.getValue());
        account.setAddress("Hồ Chí Minh");
        account.setPhone("091564567");
        account.setUsername("user");
        account.setEmail("user@gmail.com");
        account.setStatus(Account.Status.ACTIVE.getValue());
        account.setPassword(passwordEncoder.encode("user"));

        accountRepository.save(account);
    }

    void seedingCategory() {
        categoryRepository.deleteAll();
        categoryRepository.resetIncrement();

        ProductCategory productCategory = new ProductCategory();

        productCategory = new ProductCategory();
        productCategory.setName("Áo dài cưới");
        productCategory.setPrice(1200000);
        productCategory.setDescription("Áo dài cưới");
        productCategory.setStatus(1);
        productCategoryList.add(productCategory);
        //nhân thêm 4 cái

        productCategory = new ProductCategory();
        productCategory.setName("Áo dài truyền thống");
        productCategory.setPrice(1200000);
        productCategory.setDescription("Áo dài truyền thống");
        productCategory.setStatus(1);
        productCategoryList.add(productCategory);

        productCategory = new ProductCategory();
        productCategory.setName("Áo dài trung niên");
        productCategory.setPrice(1500000);
        productCategory.setDescription("Áo dài trung niên");
        productCategory.setStatus(1);
        productCategoryList.add(productCategory);

        productCategory = new ProductCategory();
        productCategory.setName("Áo dài thêu");
        productCategory.setPrice(1000000);
        productCategory.setDescription("Áo dài thêu");
        productCategory.setStatus(1);
        productCategoryList.add(productCategory);

        productCategory = new ProductCategory();
        productCategory.setName("Áo dài cách tân");
        productCategory.setPrice(1000000);
        productCategory.setDescription("Áo dài cách tân");
        productCategory.setStatus(1);
        productCategoryList.add(productCategory);

        categoryRepository.saveAll(productCategoryList);
    }

    void seedingProduct() {
        productRepository.deleteAll();
        productRepository.resetIncrement();

        Product product = new Product();

        product.setName("Áo dài cưới MV501");
        product.setPrice(100000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV145.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV502");
        product.setPrice(110000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/9_aodaimissvan_com_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV503");
        product.setPrice(110000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dạ tiệc, áo dài lễ hội");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/12_2017/thumbs/850_aodaimissvan_com_4.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV504");
        product.setPrice(110000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dạ tiệc, áo dài lễ hội.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/9_aodaimissvan_com_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV505");
        product.setPrice(110000);
        product.setDescription("Những chiếc áo được may tại Áo dài Miss Vân được cách tân theo hướng hiện đại nhưng vẫn giữ được nét duyên dáng, truyền thống vốn có.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV64.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV506");
        product.setPrice(110000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài bà sui, áo dài dự tiệc, áo dài dạ hội");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/03_2018/thumbs/850_aodaimissvan_613.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV507");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/MV576_aodaimissvan_MV_77.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV508");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên tư vấn, thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV527.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);


        product = new Product();
        product.setName("Áo dài truyền thống MV509");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/01_2018/thumbs/850_aodaimissvan_4_2.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5010");
        product.setPrice(900000);
        product.setDescription("Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/08_2018/aodaimissvan_MV472.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5011");
        product.setPrice(900000);
        product.setDescription("Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/08_2018/aodaimissvan_MV472.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV507");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_0905318487_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV508");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV232.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cách tân  MV509");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV536.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5010");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV533.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5011");
        product.setPrice(900000);
        product.setDescription("Áo dài Miss Vân chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài dạ hội");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/03_2018/thumbs/850_e_aodaimissvan_2.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5012");
        product.setPrice(900000);
        product.setDescription("Những chiếc áo dài may tại Áo dài Miss Vân được cách tân theo hướng hiện đại nhưng vẫn giữ được nét duyên dáng");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/12_2017/thumbs/850_aodaimissvandep_3.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);
        productRepository.saveAll(productList);
    }
}
