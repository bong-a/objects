package theater;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    /* theater.enter()메소드의 코드가 TicketSeller.sellTo로 이동하면서
     * ticketOffice에 대한 접근은 오직 TicketSeller안에서만 가능
     * getTicketOffice()메서드 삭제됨
     * -> 따라서 TicketSeller는 ticketOffice에서 티켓을 꺼내거나 판매 요금을 적립하는 일을 스스로 수행
     * 캡슐화 : 개념적이나 물리적으로 객체 내부의 세부적인 사항을 감추는 것
     *  -> 캡슐화의 목적 : 변경을 쉬운 객체를 만드는 것
     * 캡슐화 통해 객체 내부로의 접근을 제한하면 객체와 객체 사이의 결합도를 낮출수 있기때문에 설계를 좀 더 쉽게 변경할 수 있다.*/
    public void sellTo(Audience audience) {

        /*if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        }else {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }*/
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        /*ticketOffice.sellTicketTo(audience);*/
    }
}
