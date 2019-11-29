package t1708m.fashion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import t1708m.fashion.entity.Article;
import t1708m.fashion.entity.Product;
import t1708m.fashion.entity.ProductCategory;
import t1708m.fashion.repository.BlogRepository;
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
    BlogRepository blogRepository;
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
        sendingBlog();
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

    void sendingBlog() {
        blogRepository.deleteAll();
        blogRepository.resetIncrement();

        Article article = new Article();

        article = new Article();
        article.setTitle("Cả thế giới đều biết áo dài là quốc phục Việt Nam .");
        article.setContent("Thông tin về một thương hiệu thời trang Trung Quốc đưa lên sàn diễn thời trang bộ sưu tập được gọi là \"cách tân\" những kiểu áo dài Việt Nam đã khiến dư luận đặc biệt quan tâm và bàn luận.");
        article.setThumbnail("https://image.plo.vn/w653/Uploaded/2019/cqjwqcdwp/2019_11_22/12-ao-dai_sdjr.jpg");
        article.setDescription("Câu chuyện này đặt ra bài học về việc xây dựng thương hiệu cho áo dài Việt Nam nói riêng và các thương hiệu văn hóa Việt Nam nói chung, để từ đó không chỉ giúp các sản phẩm văn hóa - nghệ thuật Việt Nam tạo ra những giá trị kinh tế cho đất nước, mà còn khẳng định giá trị văn hóa Việt Nam trên thế giới và tránh được tình trạng đánh cắp bản quyền. Tuổi Trẻ giới thiệu đến bạn đọc ý kiến của chuyên gia văn hóa và các nhà thiết kế xoay quanh vấn đề này.\n" +
                "\n" +
                "* Nhà thiết kế Minh Hạnh:\n" +
                "\n" +
                "Sự chiếm dụng văn hóa rất nguy hiểm\n" +
                "\n" +
                "Việc thương hiệu thời trang Ne-Tiger của Trung Quốc giới thiệu bộ sưu tập giống hệt các mẫu áo dài của Việt Nam là sự chiếm dụng văn hóa rất nguy hiểm, như một dạng \"đường lưỡi bò\" trong văn hóa.\n" +
                "\n Theo tôi, Việt Nam không thể đem áo dài lên Tổ chức Sở hữu trí tuệ thế giới (WIPO) đi đăng ký sở hữu trí tuệ, bởi việc đăng ký sở hữu trí tuệ thuộc về một cá nhân cụ thể. Vì vậy, để giải quyết vấn đề, phía Việt Nam phải công bố áo dài là quốc phục. Nếu chúng ta không làm vậy, một lần nữa chúng ta bị \"việt vị\" như những lần phát hiện bản đồ có \"đường lưỡi bò\" trong GPS xe hơi, trong phim ảnh...\n" +
                "\n" +
                "Thương hiệu thời trang Ne-Tiger là một trong những thương hiệu hàng đầu và có tầm ảnh hưởng lớn trong lĩnh vực thời trang ở Trung Quốc. Với tầm ảnh hưởng của mình, Ne-Tiger hoàn toàn có thể biến áo dài của Việt Nam trở thành thường phục của người dân một tỉnh nào đó ở Trung Quốc nếu chúng ta không đăng ký sở hữu trí tuệ.");
        article.setStatus(Article.Status.ACTIVE.getValue());

        blogRepository.save(article);

        article = new Article();
        article.setTitle("Xôn xao áo dài Việt Nam sẽ trở thành xu hướng thời trang thế giới");
        article.setContent("Áo dài Việt Nam, thiết kế \"nửa kín nửa hở\" tôn lên sự quyến rũ của cơ thể người phụ nữ, đã tạo nên nhiều nguồn cảm hứng sáng tạo cho các nhà thiết kế danh giá trên thế giới. ");
      article.setDescription("Trong quá khứ, giới mộ điệu cũng không ít lần chiêm ngưỡng sự hiện diện của các thiết kế mang cảm hứng trang phục truyền thống Việt Nam trên sàn diễn quốc tế. Điều đó được thể hiện rõ nét qua một số BST thuộc khuôn khổ Tuần lễ thời trang.\n" +
              "\n" +
              "Đầu tiên không thể không nhắc đến nhà thiết kế (NTK) Kelly Bui. Tại tuần lễ thời trang Thượng Hải 2016, cô đã giới thiệu đến bạn bè quốc tế BST lấy cảm hứng từ mũ quai thao, mấn, tà áo dài... đặc trưng của vùng núi cao. Bằng chất liệu nhung và da nền đen càng thể hiện được tinh thần huyền bí của các bộ trang phục. Tà áo dài tiếp tục được \"chiêu đãi\" tại tuần lễ thời trang Seoul Xuân - Hè 2019 bởi thương hiệu thời trang BNB 12. Nhà mốt này còn thể hiện nét hiện đại cho áo dài với kiểu tay phồng \"công chúa\" cùng chất liệu sequin lấp lánh. Một điểm đặc biệt trong BST của thương hiệu Emilio Pucci năm 2013 là chiếc áo khoác bomber được thêu tiếng Việt \"yêu hòa bình\" bên tay trái đã làm giới mộ điệu \"mắt chữ A, miệng chữ O\" bên cạnh những chi tiết đặc trưng của trang phục truyền thống xuyên suốt.\n" +
              "\n" +
              "Giám đốc sáng tạo Peter Dundas đã chia sẻ rằng: \"Tôi có một vài người bạn ở Việt Nam và trang phục của họ đã cuốn hút tôi. Sau đó, tôi đã bắt đầu nghiên cứu và cảm thấy rất thích thú\". Ngay từ điểm nhìn đầu tiên, bộ trang phục trong chất liệu xuyên thấu gợi cảm của thương hiệu Leonard Paris đã gợi sự liên tưởng đến áo dài nhờ vào chi tiết cổ đứng cùng phần thân có đường chiết eo tôn dáng.");
        article.setThumbnail("https://image2.tin247.com/pictures/2019/06/07/aqh1559881525.jpg");
        article.setStatus(Article.Status.ACTIVE.getValue());

        blogRepository.save(article);

        article = new Article();
        article.setTitle("Cả thế giới đều biết áo dài là quốc phục Việt Nam .");
        article.setContent("Thông tin về một thương hiệu thời trang Trung Quốc đưa lên sàn diễn thời trang bộ sưu tập được gọi là \"cách tân\" những kiểu áo dài Việt Nam đã khiến dư luận đặc biệt quan tâm và bàn luận.");
        article.setThumbnail("https://cdn.tuoitre.vn/thumb_w/586/2019/10/21/ao-dai-1571631364337486293694.jpg");
        article.setDescription("Áo dài Việt Nam vừa truyền thống vừa hiện đại. Trang phục dành cho nữ này có thể mặc mọi nơi, dùng làm trang phục công sở, đồng phục đi học, mặc đi chơi hay mặc để tiếp khách một cách trang trọng ở nhà. Việc mặc loại trang phục này không hề rườm rà hay cầu kỳ, những thứ mặc kèm đơn giản: mặc với quần lụa hay vải mềm, dưới chân đi hài, guốc, hay giày gì đều được; nếu cần trang trọng (như trang phục cô dâu) thì thêm áo choàng và khăn đóng truyền thống đội đầu, hoặc vương miện Tây phương tùy thích.\n" +
                "\n" +
                "Trước năm 1975, áo dài trắng từng là đồng phục bắt buộc của nữ sinh trung học tại miền Nam Việt Nam. Sau ngày thống nhất, một số trường đã thay áo dài bằng đồng phục riêng của trường, và tại miền Bắc hầu hết các trường, nữ sinh chỉ còn phải mặc áo dài vào ngày thứ hai chào cờ đầu tuần.\n" +
                "\n" +
                "Chiếc áo dài tân thời (tức áo dài hiện đại) hình như có cách riêng để tôn vinh mọi thân hình. Phần trên ôm sát thân nhưng hai vạt buông thật mềm mại trên đôi ống quần rộng. Hai tà xẻ trên vòng eo khiến cho cử chỉ người mặc thật thoải mái, lại tạo dáng thướt tha, tôn vẻ nữ tính, vừa kín kẽ vì toàn thân được bao bọc bởi lụa mềm, lại cũng vừa khêu gợi vì chiếc áo làm lộ ra sống eo.\n" +
                "\n" +
                "Chiếc áo dài hiện đại vì vậy mang tính cá nhân hóa rất cao: mỗi chiếc chỉ may riêng cho một người, dành cho riêng người đó. Người đi may được lấy số đo thật kỹ. Khi may xong phải qua một lần mặc thử để sửa nhỏ nữa mới hoàn thiện.");
        article.setStatus(Article.Status.ACTIVE.getValue());
        blogRepository.save(article);

        article = new Article();
        article.setTitle("Cả thế giới đều công nhận áo dài là quốc phục Việt Nam .");
        article.setContent("Thông tin về một thương hiệu thời trang Trung Quốc đưa lên sàn diễn thời trang bộ sưu tập được gọi là \"cách tân\" những kiểu áo dài Việt Nam đã khiến dư luận đặc biệt quan tâm và bàn luận.");
        article.setThumbnail("https://1.bp.blogspot.com/-KGhNlWw4UP8/XUxEuEvacfI/AAAAAAAAStA/EEBdQ9TOVx0bH8uB3ywbzyuxUBBX4_ZmgCLcBGAs/s640/ntk-minh-chau-bst-ao-dai-mua-vu-lan.jpg");
        article.setDescription("Câu chuyện này đặt ra bài học về việc xây dựng thương hiệu cho áo dài Việt Nam nói riêng và các thương hiệu văn hóa Việt Nam nói chung, để từ đó không chỉ giúp các sản phẩm văn hóa - nghệ thuật Việt Nam tạo ra những giá trị kinh tế cho đất nước, mà còn khẳng định giá trị văn hóa Việt Nam trên thế giới và tránh được tình trạng đánh cắp bản quyền.  ");
        article.setStatus(Article.Status.ACTIVE.getValue());

        blogRepository.save(article);
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

        productCategory = new ProductCategory();
        productCategory.setName("Áo dài nam");
        productCategory.setPrice(2000000);
        productCategory.setDescription("Áo dài nam");
        productCategory.setStatus(1);
        productCategoryList.add(productCategory);

        categoryRepository.saveAll(productCategoryList);
    }

    void seedingProduct() {
        productRepository.deleteAll();
        productRepository.resetIncrement();

            Product product = new Product();



        product.setName("Áo dài cưới MV501");
        product.setPrice(1500000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV145.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV502");
        product.setPrice(1700000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/9_aodaimissvan_com_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV503");
        product.setPrice(1700000);
        product.setDescription("Khách hàng đặt may online chỉ cần gửi thông tin chiều cao, cân nặng, số đo 3 vòng và chiều cao của giày khi mặc áo dài hoặc gửi số đo qua website http://toangstore.com/gui-so-do.html");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/12_2017/thumbs/850_aodaimissvan_com_4.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV505");
        product.setPrice(2000000);
        product.setDescription(" Nhận may áo dài toàn quốc và gửi ra nước ngoài. Khách hàng đặt may online chỉ cần gửi thông tin chiều cao, cân nặng, số đo 3 vòng và chiều cao của giày khi mặc áo dài");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/04_2018/thumbs/850_MV_6_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV506");
        product.setPrice(2000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV117.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV507");
        product.setPrice(2000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV172.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV508");
        product.setPrice(1900000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dạ tiệc, áo dài lễ hội.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/01_2018/aodaimissvan.com_61.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV509");
        product.setPrice(3500000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dạ tiệc, áo dài lễ hội.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV520.png");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cưới MV5010");
        product.setPrice(3000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dạ tiệc, áo dài lễ hội.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV503.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV5011");
        product.setPrice(1000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/12_2018/aodaimissvan_22_4.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV5012");
        product.setPrice(1100000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV527.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV513");
        product.setPrice(1900000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV526.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV514");
        product.setPrice(1200000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV524.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV515");
        product.setPrice(1800000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV522.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV516");
        product.setPrice(1700000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV521.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV517");
        product.setPrice(1000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội;  cấp các loại vải tốt  nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/07_2018/aodaimissvan_MV521.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV518");
        product.setPrice(1000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh̃");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/08_2018/aodaimissvan.com_MV436.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV519");
        product.setPrice(1300000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/08_2018/aodaimissvan.com_MV398.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài trung niên MV520");
        product.setPrice(1400000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/12_2017/thumbs/850_aodaimissvan_MV_30_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5021");
        product.setPrice(900000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/08_2018/aodaimissvan.com_MV392.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5022");
        product.setPrice(2000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV358.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5023");
        product.setPrice(2100000);
        product.setDescription("Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV358.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV524");
        product.setPrice(2900000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV329_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5025");
        product.setPrice(2900000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/12_2018/aodaimissvan_9.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5026");
        product.setPrice(2700000);
        product.setDescription("Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV253.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV527");
        product.setPrice(2200000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV248.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5028");
        product.setPrice(2400000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV224.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV5029");
        product.setPrice(2300000);
        product.setDescription("Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV210.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài truyền thống MV530");
        product.setPrice(2500000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/02_2018/thumbs/850_aodaimissvan_126_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);


        product = new Product();
        product.setName("Áo dài thêu  MV5031");
        product.setPrice(1000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV339.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5032");
        product.setPrice(1100000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV329_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5033");
        product.setPrice(1200000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV327.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5034");
        product.setPrice(1300000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV317.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5035");
        product.setPrice(1400000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV75.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5036");
        product.setPrice(1500000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV18.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5037");
        product.setPrice(1600000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV258.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5038");
        product.setPrice(1700000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/02_2018/thumbs/850_1_aodaimissvan_1_4.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5039");
        product.setPrice(1800000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế  áo dài dạ hội; Cung cấp các loại vải tốt và thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của quý khách hàng như áo dài cưới truyền thống, áo dài cưới cách tân, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài nữ sinh");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV179.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài thêu  MV5040");
        product.setPrice(1900000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV231.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cách tân  MV5041");
        product.setPrice(1000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("https://quyennguyen.vn/wp-content/uploads/2019/03/ao-dai-cach-tan-danh-cho-nguoi-lun.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5042");
        product.setPrice(1100000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("https://quyennguyen.vn/wp-content/uploads/2018/12/ao-dai-cach-tan-AD-CT01.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5043");
        product.setPrice(1200000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài dạ hội");
        product.setPhotos("https://www.marry.vn/wp-content/uploads/2017/07/26/vai-may-ao-dai-cach-tan-4.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5044");
        product.setPrice(1300000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://cdn01.diadiemanuong.com/ddau/640x/bat-mi-6-shop-ao-dai-cach-tan-me-va-be-uy-tin-o-sai-gon-62a21c20636185996920918814.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài cách tân  MV545");
        product.setPrice(1400000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("https://mtv-fashion.com/wp-content/uploads/2018/08/ao-dai-cach-tan-phoi-ren-1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5046");
        product.setPrice(1500000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("https://sallynguyen.vn/wp-content/uploads/2019/03/vai-ao-dai-cach-tan-in-hoa-sen-3d-604-10.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5047");
        product.setPrice(1600000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("https://quyennguyen.vn/wp-content/uploads/2018/12/ao-dai-cach-tan-AD-CT12.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5048");
        product.setPrice(1700000);
        product.setDescription("Những chiếc áo dài may tại Áo dài Toang Store được cách tân theo hướng hiện đại nhưng vẫn giữ được nét duyên dáng");
        product.setPhotos("https://cdn.nhanh.vn/cdn/store/13529/psCT/20181227/10872254/DAM_CACH_TAN_PLTK121804_(pltk121804_(8)).jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5049");
        product.setPrice(1800000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài dạ hội");
        product.setPhotos("https://aodaiovera.com/img/image/mau-ao-dai-cach-tan-dep-1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo cách tân  MV5050");
        product.setPrice(1900000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("https://quyennguyen.vn/wp-content/uploads/2018/12/ao-dai-cach-tan-AD-CT07.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5051");
        product.setPrice(1000000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV3.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5052");
        product.setPrice(1100000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/03_2018/thumbs/850_3_aodaimissvan_2_1.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5053");
        product.setPrice(1200000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài dạ hội");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV4.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5054");
        product.setPrice(1300000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV5.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5055");
        product.setPrice(1400000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV6.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5056");
        product.setPrice(1500000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài lễ hội, áo dài truyền thống, áo dài cách tân, áo dài công sở, áo dài vẽ, áo dài in, áo dài giáo viên, áo dài nữ sinh.");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/03_2018/thumbs/850_aodaimissvan_10_2.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5057");
        product.setPrice(1600000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV47.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5058");
        product.setPrice(1700000);
        product.setDescription("Những chiếc áo dài may tại Áo dài Toang Store được cách tân theo hướng hiện đại nhưng vẫn giữ được nét duyên dáng");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV48.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5059");
        product.setPrice(1800000);
        product.setDescription("Áo dài Toang Store chuyên thiết kế và may các mẫu áo dài cưới hỏi, áo dài cho mẹ cô dâu chú rễ, áo dài dự tiệc, áo dài dạ hội");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/09_2018/aodaimissvan.com_MV308.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        product = new Product();
        product.setName("Áo dài nam  MV5060");
        product.setPrice(1900000);
        product.setDescription("Cung cấp các loại vải , thịnh hành nhất hiện nay để đáp ứng nhu cầu đặt may áo dài đa dạng của Quý khách hàng như áo dài truyền thống");
        product.setPhotos("http://aodaimissvan.com/vnt_upload/product/03_2018/thumbs/850_aodaimissvan_17_3.jpg");
        product.setStatus(Product.Status.ACTIVE.getValue());
        product.setCategory(productCategoryList.get(new Random().nextInt(productCategoryList.size())));
        productList.add(product);

        productRepository.saveAll(productList);
    }

}
