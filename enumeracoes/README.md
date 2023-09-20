# Enumerações

- É um tipo especial que serve para especificar de forma literal um conjunto de constantes relacionadas;
  - Palavra chave em Java: 
    > enum
- Vantagens: 
  - melhor semântica; 
  - código mais legível;
  - auxiliado pelo compilador;

      [Link de Referência](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

## Exemplo:

Vamos supor que o cliente tem um sistema de comércio com um pedido:

    Esses Pedidos feitos pelos compradores (clientes), possuem um ciclo de vida:
    Seguindo a lógica de uma compra feita pela internet, o processo seria:
    O pedido é feito, assim que o pagamento for autorizado, após a preparação do pedido ele é despachado até chegar seu destino de entrega.

Então os _estados_ em que o pedido passa ao longo do seu ciclo de vida são:

1 - **Pagamento Pendente** - [PendingPayment]

2 - **Preparando** - [Preparing]

3 - **Encaminhado** - [Forwarded]

4 - **Entregue** - [Delivered]

A representação semântica desses estados para que facilite o manuseio do programador é feita pelo tipo enumerado (ou enumeração).

Exemplo:

>   package entities.enums;
>
>   public enum OrderStatus {
>       PENDING_PAYMENT;
>       PREPARING;
>       FORWARDED;
>       DELIVERED;
>   }

Depois definimos uma classe Pedido (Order), declarando o Status do Pedido (OrderStatus):

>   package entities;
>   import java.util.Date;
>   import entities.enums.Order.Status;
> 
>   public class Order {
>   
>       private Integer id;
>       private Date moment;
>       private OrderStatus status;
> 
>   }

Abrir o [projeto]

### Conversão de String para enum

> OrderStatus os1 = OrderStatus.DELIVERED;

> OrderStatus os2 = OrderStatus.valueOf("DELIVERED");


### Notação UML

>         <enum>
> 
>     **OrderStatus**
> -----------------------
> PENDING_PAYMENT int = 0
> PREPARING int = 1
> FORWARDED int = 2
> DELIVERED int = 3
