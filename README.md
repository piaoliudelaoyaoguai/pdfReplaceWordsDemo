# java itext替换PDF中的文本。
# itext没有提供直接替换PDF文本的接口，我们可以通过在原有的文本区域覆盖一个遮挡层，再在上面加上文本来实现。
# jar包在jars文件夹中，测试PDF在resource文件夹中，STSONG.TTF文件是Windows的一个中文字体。
# 注：如果不好确定替换区域的坐标位置，而PDF对应区域又是空白的话，可以在生成PDF的时候，在需要替换的区域先写入“特定文字内容”，预设的文字颜色设置和背景色相同，这样PDF看起来似乎是空的，但是却可以用查找文本的方式替换，替换后的就能显示出替换后的内容了，这样有时候可以方便很多。
# 附：替换后的文本在PC端、Android端、iOS端都是可以打开和使用，在HTML5开发时使用PDF.js插件时发现替换后的字体不显示的情况，这是由于PDF.js插件不识别iTextAsign.jar中的字体，把：BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED)做下修改，可以使用Windows中的字体：BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/STSONG.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED)，字体和路径路径可以自行设置，linux中先安装中文字体库，再使用相应字体的路径即可。替换字体后，网页中使用PDF.js插件也没问题了。
