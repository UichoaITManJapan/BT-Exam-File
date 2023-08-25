    package ra.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

    public class Student implements IEntity<Student>, Serializable {
    private String studentId;
    private String studentName;
    private java.util.Date brithday;
    private int age;
    private boolean sex;
    private float mark_html;
    private float mark_css;
    private float mark_javascript;
    private float avgMark;
    private String rank;

    public Student() {
    }

    public Student(String studentId, String studentName, Date brithday, int age, boolean sex, float mark_html, float mark_css, float mark_javascript, float avgMark, String rank) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.brithday = brithday;
        this.age = age;
        this.sex = sex;
        this.mark_html = mark_html;
        this.mark_css = mark_css;
        this.mark_javascript = mark_javascript;
        this.avgMark = avgMark;
        this.rank = rank;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getMark_html() {
        return mark_html;
    }

    public void setMark_html(float mark_html) {
        this.mark_html = mark_html;
    }

    public float getMark_css() {
        return mark_css;
    }

    public void setMark_css(float mark_css) {
        this.mark_css = mark_css;
    }

    public float getMark_javascript() {
        return mark_javascript;
    }

    public void setMark_javascript(float mark_javascript) {
        this.mark_javascript = mark_javascript;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void inputData(Scanner scanner, List<Student> list) {
        this.studentId = validateStudentId(scanner,list);
        this.studentName = validateStudentName(scanner);
        this.brithday = validateBirthday(scanner);
        this.sex = validateSex(scanner);
        this.mark_html = validateHtml(scanner);
        this.mark_css = validateCss(scanner);
        this.mark_javascript = validateJavascript(scanner);

    }
   public String validateStudentId(Scanner scanner,List<Student> list){
       System.out.println("Nhập vào mã sinh viên:");
       do {
           String studentId = scanner.nextLine();
           if (studentId.length() == 4) {
               if (studentId.startsWith("S")) {
                   boolean isExist = false;
                   for (Student student : list) {
                       if (student.getStudentId().equals(studentId)) {
                           isExist = true;
                           break;
                       }
                   }
                   if (!isExist) {
                       return studentId;
                   } else {
                       System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
                   }
               } else {
                   System.err.println("Mã sinh viên phải bắt đầu là ký tự S, vui lòng nhập lại");
               }
           } else {
               System.err.println("Mã sinh viên phải gồm 4 ký tự, vui lòng nhập lại");
           }
       } while (true);
   }
   public static String validateStudentName(Scanner scanner){
       System.out.println("Nhập vào tên sinh viên:");
       do {
           String studentName = scanner.nextLine();
           if (studentName.length() >= 10 && studentName.length() <= 50) {
               return studentName;
           } else {
               System.err.println("Tên sinh viên có độ dài từ 10-50 ký tự, vui lòng nhập lại");
           }
       } while (true);
   }
   public static Date validateBirthday(Scanner scanner){
       System.out.println("nhập vào ngày sinh của sinh viên :");
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       do {
           try {
               Date birthday = sdf.parse(scanner.nextLine());
               Calendar calendar = Calendar.getInstance();
               calendar.setTime(birthday);
               if (calendar.get(Calendar.YEAR) < 2005){
                   return birthday;
               } else {
                   System.err.println("Năm sinh phải trước năm 2005, vui lòng nhập lại");
               }
           } catch (ParseException ex1) {
               System.err.println("Ngày sinh phải có định dạng dd/MM/yyyy, vui lòng nhập lại");
           } catch (Exception ex) {
               System.err.println("Xảy ra lỗi không xác định, vui lòng liên hệ với hệ thống");
           }
       } while (true);
   }
   public static boolean validateSex(Scanner scanner){
       System.out.println("Nhập vào giới tính sinh viên :");
       do {
           String sex = scanner.nextLine();
           if (sex.equalsIgnoreCase("true") || sex.equalsIgnoreCase("false")){
               return Boolean.parseBoolean(sex);
           } else {
               System.err.println("Giới tính chỉ nhận giá trị 'true' hoặc 'false'. Vui lòng nhập lại!");
           }
       } while (true);
   }
   public static float validateHtml(Scanner scanner){
       System.out.println("Nhập vào điểm html :");
       do {
           try {
               float mark_html = Float.parseFloat(scanner.nextLine());
               if (mark_html >=0 && mark_html <= 10){
                   return mark_html;
               } else {
                   System.err.println("Điểm HTMl phải có gá trị từ 0 đến 10. Vui lòng nhập lại!");
               }
           } catch (NullPointerException ex1){
               System.err.println("Lỗi " +ex1.getMessage() + ". Vui lòng nhập lại!");
           } catch (NumberFormatException ex2){
               System.err.println("Lỗi " + ex2.getMessage() +". Vui lòng nhập lại!");
           } catch (Exception exception){
               System.err.println("Xảy ra lỗi trong quá trình xử lý dữ liệu. Vui lòng nhập lại!");
           }
       } while (true);
   }
   public static float validateCss(Scanner scanner){
       System.out.println("Nhập vào điểm css :");
       do {
           try {
               float mark_css = Float.parseFloat(scanner.nextLine());
               if (mark_css >=0 && mark_css <= 10){
                   return mark_css;
               } else {
                   System.err.println("Điểm CSS phải có gá trị từ 0 đến 10. Vui lòng nhập lại!");
               }
           } catch (NullPointerException ex1){
               System.err.println("Lỗi " +ex1.getMessage() + ". Vui lòng nhập lại!");
           } catch (NumberFormatException ex2){
               System.err.println("Lỗi " + ex2.getMessage() +". Vui lòng nhập lại!");
           } catch (Exception exception){
               System.err.println("Xảy ra lỗi trong quá trình xử lý dữ liệu. Vui lòng nhập lại!");
           }
       } while (true);
   }
   public static float validateJavascript(Scanner scanner){
       System.out.println("Nhập vào điểm javascript :");
       do {
           try {
               float mark_javascript = Float.parseFloat(scanner.nextLine());
               if (mark_javascript >=0 && mark_javascript <= 10){
                   return mark_javascript;
               } else {
                   System.err.println("Điểm Javascript phải có gá trị từ 0 đến 10. Vui lòng nhập lại!");
               }
           } catch (NullPointerException ex1){
               System.err.println("Lỗi " +ex1.getMessage() + ". Vui lòng nhập lại!");
           } catch (NumberFormatException ex2){
               System.err.println("Lỗi " + ex2.getMessage() +". Vui lòng nhập lại!");
           } catch (Exception exception){
               System.err.println("Xảy ra lỗi trong quá trình xử lý dữ liệu. Vui lòng nhập lại!");
           }
       } while (true);
   }
    @Override
    public void displayData() {
        String stringSex = this.sex ? "Nam" : "Nữ";
        System.out.println("Mã sinh viên : " + this.studentId + "-" + "Tên sinh viên :" + this.studentName);
        System.out.println("Sinh nhật : " + this.brithday + "-" + "Tuổi sinh viên :" + this.age);
        System.out.println("Giới tính : " + stringSex +"-" +"Điểm html : " + this.mark_html +"-" + "Điểm css : " + this.mark_css);
        System.out.println("Điểm javascript :" + this.mark_javascript + "-"+"Điểm trung bình :" + this.avgMark);
        System.out.println("Xếp loại : "+this.rank);
    }

    @Override
    public void calAge() {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        cal.setTime(brithday);
        int birthdayYear = cal.get(Calendar.YEAR);
        this.age = currentYear - birthdayYear;
        System.out.println("Tuổi sinh viên là :" + this.age);
    }

    @Override
    public void calAVgMark_Rank() {
        this.avgMark = (mark_html + mark_css + mark_javascript)/3;
        if (this.avgMark < 5){
            this.rank = "Yếu";
        } else if (this.avgMark >=5 && this.avgMark < 7) {
            this.rank = "Trung bình";
        } else if (this.avgMark >=7 && this.avgMark <8){
            this.rank = "Khá";
        } else if (this.avgMark >=8 && this.avgMark < 9) {
            this.rank = "Giỏi";
        } else {
            this.rank = "Xuất sắc";
        }
    }
}
