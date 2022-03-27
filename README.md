# Patika-Java-Bootcamp-Hafta-3

## Liste sınıfı yapmak
Kendi Liste Sınıfımızı Yazmak
Java'da generic yapısını kullanarak verileri tuttuğumuz bir sınıf tasarlıyoruz.
Sınıfın amacı içerisinde dinamik bir Array (Dizi) tutması ve veri tipini dinamik olarak alması. Bunun için generic bir sınıf oluşturulması gerekli.

## Kitap Sıralayıcı
Book isminde bir sınıf tasarlayınız. Bu sınıf Comparable interface'den kalıtım alıp "compareTo" metodunu override ediniz. Bu metodun içinde kitabı A'dan Z'ye isme göre sıralayan kodu yazınız. Bu sınıftan 5 tane nesne oluşturun ve nesneleri Set tipinde bir yapısında saklayınız. Sonra ikinci kez Set tipinden bir veri yapısı kullanın ve kitapları sayfa sayısına göre sıralamasını sağlayınız.
Book sınıfı kitap ismi, sayfa sayısı, yazarın ismi, yayın tarihi değişkenlerinden oluşmaktadır

## Fikstür Oluşturucu
Java ile girilen takımlar için rastgele maç fikstürü oluşturan bir sınıf yazılmalı.
Kurallar :
- Çift Devreli Lig usülü uygulanacaktır. Her takım diğer takımlarla kendi evinde ve deplasmanda olmak üzere iki maç yapacaktır.
- Listenin sol tarafı ev sahibini sağ tarafı deplasman takımını gösterir.
- Eğer tek sayıda takım listesi girilirse, çift sayıya tamamlanacak şekilde "Bay" adında bir takım daha eklenmeli. Bay ile eşleşen takımlar o hafta maç yapmayacağı anlamına gelir.

## PatikaStore
Patika ekibi elektronik eşyaların satıldığı bir sanal bir mağaza açmaya karar verdi ve bu mağazanın ürün yönetim sistemini siz patika gönüllülerinden yapmasını ekliyor.

Sanal Mağazanın adı "PatikaStore" olacaktır.

Mağazada Markalar oluşturulacak ve ürünler bu markalar ile eşleşecektir.

id : Markanın sistemde kayıtlı benzersiz numarası

name : Markanın adı

Markalar listelenirken her zaman alfabe sırasıyla listelenmelidir.

Markalar statik olarak kod blokları içerisinden aşağıdaki sıra ile eklenmelidir.

Markalar : Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster

Mağazada şuan için 2 tür ürün grubu satılması planlanmaktadır : Cep Telefonları, Notebook

Daha sonrasında farklı ürün gruplarını eklenebilir olmalıdır.

Cep Telefonu ürünlerinin özellikleri :

Ürünün sistemde kayıtlı benzersiz numarası

Birim fiyatı

İndirim oranı

Stok miktarı

Ürün adı

Marka bilgisi (Sistemde ekli olan markalar kullanılacaktır)

Telefonun hafıza bilgisi (128 GB, 64 GB)

Ekran Boyutu (6.1 Inc)

Pil Gücü (4000)

RAM (6 MB)

Renk (Siyah,Kırmızı,Mavi)

Notebook ürünlerinin özellikleri :

Ürünün sistemde kayıtlı benzersiz numarası

Birim fiyatı

İndirim oranı

Stok miktarı

Ürün adı

Marka bilgisi (Sistemde ekli olan markalar kullanılacaktır)

Ram (8 GB)

Depolama (512 SSD)

Ekran Boyutu (14 inç)

Kullanıcı sistem üzerinden ilgili kategorideki (Notebook, Cep Telefonları vb.) ürünleri listeyebilimeli

Ürünler listelenirken tablo şeklinde konsol ekranında gösterilmeli (System.out.format() kullanılabilir).

Kullanıcı ürün ekleyebilmeli ve ürünün grubunu (Cep Telefonu, Notebook vb.) seçebilmeli.

Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli.

Kullanıcı ürünlerin benzersiz numaralarına ve markalarına göre filtreleyip listeleyebilmeli.
