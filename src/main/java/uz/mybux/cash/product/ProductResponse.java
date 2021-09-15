package uz.mybux.cash.product;


import org.springframework.beans.factory.annotation.Value;

public interface ProductResponse{
  Long getId();
  String getName();
  String getBarCode();
  String getLabel();
  Double getPrice();
  Double getDiscount();
  Double getVat();
  Double getGroupId();
  @Value("#{target.productTypeName.name}")
  String getMeasureName();
  String getPhoto();

}