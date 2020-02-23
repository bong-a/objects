# CHAPTER03 역할, 책임, 협력

> 객체지향 패러다임의 관점에서 핵심은 역할, 책임, 협력이다.

클래스와 상속은 객체들의 책임과 협력이 어느 정도 자리를 잡은 후에 사용할 수 있는 구현 매커니즘일 뿐이다.

역할과 책임에 대한 고민하지 않은 채 너무 이른 시기에 구현에 초점맞추는 것은 변경하기 어렵고 유연하지 못한 코드는 낳는 원인이 된다.

## 01.  협력

### 영화예매시스템 돌아보기

객체지향 원칙을 따르는 애플리케이션의 제어 흐름은 어떤 하나의 객체에 의해 통제되지 않고 다양한 객체들 사이에 균형있게 분배되는 것이 일반적이다.

다양한 객체들이 영화 예매라는 기능을 구현하기 위해 메세지를 주고받으면서 상호작용한다는 점이 중요하다.

- `협력` : 객체들이 애플리케이션의 기능을 구현하기 위해 수행하는 상호작용

- `책임` : 객체가 협력에 참여하기 위해 수행하는 로직
- 객체들이 협력 안에서 수행하는 책임들이 모여 객체가 수행하는 `역할`을 구성한다.

### 협력

협력은 객체지향의 세계에서 기능을 구현할 수 있는 유일한 방법이다

두 객체 사이의 협력은 하나의 객체가 다른 객체에게 도움을 요청할 때 시작된다.

`메세지 전송`은 객체 사이의 협력을 위해 사용할 수 있는 유일한 커뮤니케이션 수단이다.

객체는 다른 객체의 상세한 내부 구현에 직접 접근할 수 없기 때문에 오직 메세지 전송을 통해서만 자신의 요청을 전달할 수 있다.

- 메세지를 수신한 객체는 메서드를 실행해 요청에 응답한다.
  - 여기서 객체가 메세지를 처리할 방법을 스스로 선택한다는 점이 중요하다.
  - 외부 객체는 오직 메세지만 전송할뿐 메세지를 어떻게 처리할지는 메세지를 수신한 객체가 직접 결정한다.
  - 이것은 객체가 자신의 일을 스스로 처리할 수 있는 자율적인 존재라는 것을 의미한다.
- 객체를 자율적으로 만드는 방법 = 캡슐화

### 협력이 설계를 위한 문맥을 결정한다

애플리케이션 안에 어떤 객체가 필요하다면 그 이유는 단 하나여야 한다.

그 객체가 어떤 협력에 참여하고 있기 때문이다. 그리고 객체가 협력에 참여할 수 있는 이유는 협력에 필요한 적절한 행동을 보유하고 있기 때문이다.

- 객체의 행동을 결정하는 것은 객체가 참여하고 있는 협력이다.
- 협력이 바뀌면 객체가 제공해야하는 행동 역시 바뀌어야 한다.
- 협력은 객체가 필요한 이유와 객체가 수행하는 행동의 동기를 제공한다.
- 객체의 상태를 결정하는 것은 행동이다.
  - 객체의 상태는 그 객체가 행동을 수행하는 데 필요한 정보가 무엇인지로 결정된다.

결과적으로 객체가 참여하는 협력이 객체를 구성하는 행동과 상태 모두를 결정한다.

따라서 협력은 객체를 설계하는 데 필요한 일종의 문맥을 제공한다.



## 02. 책임

### 책임이란 무엇인가

협력이 갖춰지면 다음으로 할 일은 협력에 필요한 행동을 수행할 수 있는 적절한 객체를 찾는  것이다.

`책임` : 객체가 협력에 참여하기 위해 수행하는 로직(행동)

객체의 책임은 

- 객체가 `무엇을 알고 있는가` = 아는 것
  - 사적인 정보에 관해 아는 것
  - 관련된 객체에 관해 아는 것
  - 자신이 유도하거나 계산할 수 잇는 것에 관해 아는 것
- 객체가 `무엇을 할 수 있는가` = 하는 것
  - 객체를 생성하거나 계산을 수행하는 등의 스스로 하는것
  - 다른 객체의 행동을 시작시키는 것
  - 다른객체의 활동을 제어하고 조절하는 것

로 구성된다.

- 협력안에서 객체에게 할당한 책임이 외부의 인터페이스와 내부의 속성을 결정한다

- 일반적으로 책임과 메세지의 크기는 다른다. 책임이 메세지보다 추상적이고 개념적으로도 더 크다.

- 적절한 협력 -> 적절한 책임 제공 -> 적절한 책임을 적절한 객체에게 할당 -> 단순하고 유연한 설계 창조 할 수 있다.
- 객체에게 얼마나 적절한 책임을 할당하느냐가 설계의 전체적인 품질을 결정한다.

### 책임 할당

자율적인 객체를 만드는 기본적인 방법은 필요한 정보를 가장 잘 알고 있는 전문가에게 그 책임을 할당하는 것이다.

이를 책임 할달을 위한 INFORMATION EXPERT(정보 전문가) 패턴이라고 부른다.

- 일상생활에서 도움을 요청하는 방식과 유사하다.
- 그 일을 처리하는데 필요한 지식과 방법을 가장 잘 알고 있는 전문가에게 도움을 요청한다.
- 객체 세계에서도 마찬가지로 가장 잘알고있는 객체에게 도움을 요청한다.
- 요청에 응답하기 위해 필요한 이 행동이 객체가 수행할 책임으로 이어지는 것이다.

협력을 설계하는 출발점은 시스템이 사용자에게 제공하는 기능을 시스템이 담당할 하나의 책임으로 바라보는 것이다.

객체지향설계는 시스템의 책임을 완료하는 데 필요한 더 작은 책임을 찾아내고 이를 객체들에게 할당하는 반복적인 과정을 통해 모양을 갖춰간다.

협력을 설계하면서 객체의 책임을 식별해 나가는 과정에서 최종적으로 얻게되는 결과물은 시스템을 구성하는 객체들의 인터페이스와 오퍼레이션의 목록이다.

어떤 경우에는 응집도와 결합도의 관점에서 정보 전문가가 아닌 다른 객체에게 책임을 할당하는 것이 더 적절한 경우도 있다.

### 책임 주도 설계

앞의 내용을 정리하자면 협력을 설계하기 위해서는 책임에 초점을 맞춰야 한다는 것이다.

어떤 책임을 선택하느냐가 전체적인 설계의 방향과 흐름을 결정한다.

`책임 주도 설계(Responsibility-Driven Design,RDD)` : 책임을 찾고 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방식으로 협력을 설계하는 방법

- 시스템이 사용자에게 제공해야 하는 기능인 시스템 책임을 파악한다.
- 시스템 책임을 더 작은 책임으로 분할한다.
- 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.
- 객체가 책임을 수행하는 도중 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.
- 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 한다.

구현이 아닌 책임에 집중하는 것이 중요한 이유는 유연하고 견고한 객체지향 시스템을 위해 가장 중요한 재료가 바로 책임이기 때문이다.



### 책임을 할당할 때 고려해야하는 두가지 요소

#### 1. 메세지가 객체를 결정한다

객체에게 책임을 할당하는데 필요한 메세지를 먼저 식별하고 메세지를 처리할 객체를 나중에 선택했다는 것이 중요하다.

다시 말해 객체가 메세지를 선택하는 것이 아니라 메세지가 객체를 선택하게 했다.

메세지가 객체를 선택하게 해야하는 이유

1. 객체가 최소한의 인터페이스를 가질수 있게 된다.

   필요한 메세지가 식별될 때까지 객체의 퍼블릭 인터페이스에 어떤 것도 추가하지 않기 때문에 객체는 애플리케이션에 크지도, 작지도 않은 꼭 필요한 크기의 퍼블릭 인터페이스를 가질  수 있다.

2. 객체는 충분히 추상적인 인터페이스를 가질 수 있게 된다.

   객체의 인터페이스는 무엇을 하는지는 표현해야 하지만 어떻게 수행하는지를 노출해서는 안된다.

   메세지는 외부의 객체가 요청하는 무언가를 의미하기 때문에 메세지를 먼저 식별하면 무엇을 수행할지에  초점을 맞추는 인터페이스를 얻을 수 있다.

#### 2. 행동이 상태를 결정한다

객체가 존재하는 이유는 협력에 참여하기 위해서다. 객체는 협력에 필요한 행동을 제공해야한다.

객체를 객체답게 만드는 것은 객체의 상태가 아니라 객체가 다른객체에게 제공하는 행동이다.

객체의 행동은 객체가 협력에 참여할 수 있는 유일한 방법이다.

객체가 협력에 적합한지를 결정하는 것은 그 객체의 상태가 아니라 행동이다.

얼마나 적저한 객체를 창조했냐는 얼마나 적절한 책임을 할당했느냐에 달려있고, 책임이 얼마나 적절한지는 협력에 얼마나 적절한가에 달려있다.

객체지향 패러다임에 갓 입문한 사람들이 가장 쉽게 빠지는 실수는 객체의 행동이 아니라 상태에 초점을 맞추는 것이다. 

- 먼저 객체에 필요한 상태가 무엇인지 결정하고
- 그 후에 상태에 필요한 행동을 결정한다
- 이런 방식은 객체 내부 구현이 객체의 퍼블릭 인터페이스에 노출되도록 만들기 때문에 캡슐화를 저해한다.
- 객체 내부 구현을 변경하면 퍼블릭 인터페이스도 함께 변경되고, 결국 객체에 의존하는 클라이언트로 변경의 영향이 전파된다.
- 객체 내부 구현에 초점을 맞춘 설계 방법을 데이터 주도 설계(DDD)라고 부른다.

캡슐화를 위반하지 않도록 구현에 대한 결정을 뒤로 미루면서 객체의 행위를 고려하기 위해서는 항상 협력이라는 문맥안에서 객치를 생각해야한다.

상태는 단지 객체가 행동을 정상적으로 수행하기 위해 필요한 재료일뿐이다.

협력이 객체의 행동을 결정하고 행동이 상태를 결정한다. 그 행동이 바로 객체의 책임이 된다.



## 03. 역할

객체가 어떤 특정한 협력 안에서 수행하는 책임의 집합을 역할이라고 부른다.

협력을 모델링할 때는 특정한 객체가 아니라 역할에게 책임을 할당한다고 생각하는게 좋다.

어떤 이유로 역할이라는 개념을 이용해서 설계 과정을 더 번거롭게 만드는 것일까?

역할이 없어도 객체만으로 충분히 협력을 설계할 수 있는 것 아닌가?

### 유연하고 재사용 가능한 협력

역할을 통해 유연하고 재사용 가능한 협력을 얻을수 있다.

역할이라는 개념을 고려하지 않고 객체에게 책임을 할당하면 코드 중복이 발생할 수 있다.

프로그래밍에서 코드 중복은 모든 문제의  근원이기 때문에 이런 방법은 피해야 한다.

문제를 해결하기 위해서는 객체가 아닌 책임에 초점을 맞춰야 한다.

영화 예매 시스템의 일정 금액 할인 정책과 비율 할인 정책을 보면 동일한 책임을 수행하는 역할을 기반으로 두 개의 협력을 하나로 통합할 수 있다. 따라서 역할을 이용하면 불필요한 중복코드를 제거할수 있다.

책임과 역할을 중심으로 협력을 바라보는 것이 바로 변경과 확장이 용이한 유연한 설계로 나아가는 첫걸음이다.

#### 역할의 구현

- 역할을 구현하는 가장 일반적인 방법은 추상 클래스와 인터페이스를 사용하는 것이다.
  - 협력의 관점에서 
    - 추상 클래스는 책임의 일부를 구현해 놓은 것
    - 인터페이스는 일체의 구현 없이 책임의 집합만을 나열해 놓은 것
    - 둘 모두 역할을 정의할 수 있는 구현 방법이라는 공통점을 공유한다.
- 역할이 다양한 종류의 객체를 수용할 수 있는 일종의 슬롯이자 구체적인 객체들의 타입을 캡슐화하는 추상화라는 것이 중요하다.
- 협력안에서 역할이 어떤 책임을 수행해야 하는지 결정하는 것이 중요하다. 역할을 구현하는 것은 그 다음 문제다.
- 객체에게 중요한 것은 행동이며, 역할은 객체를 추상화해서 객체 자체가 아닌 협력에 초점을 맞출 수 있게 한다.

### 객체 대 역할

역할은 객체가 참여할 수 있는 일종의 슬롯이다. -> 유용하고 재사용 가능한 설계라는 문맥에서 역할의 중요성은 매우 크다.

- 협력에 참여하는 후보가 여러 종류의 객체에 의해 수행될 필요가 있다면 그후보는 역할이 된다.
- 단지 한 종류의 객체만이 협력에 참여할 필요가 있다면 후보는 객체가 된다.

설계 초반에는 적절한 책임과 협력의 큰 그림을 탐색하는 것이 가장 중요한 목표여야 한다.

역할과 객체를 명확하게 구분하는 것은 그렇게 중요하지 않다.

애매하다면 단순하게 객체로 시작하고 반복적으로 책임과 협력을 정제해가면서 필요한 순간에 객체로부터 역할을 분리해내는 것이 가장 좋은 방법이다.

역할 모델링은 UML에 큰 영향을 미치기도 했으며 최근의 객체지향 언어와 설계 기법들은 역할을 중요한 구성 요소로 간주하기 시작했다.

중요한 것은 협력을 구체적인 객치가 아니라 추상적인 역할의 관점에서 설계하면 협력이 유연하고 재사용 가능해진다는 것이다.

역할의 가장 큰 장점은 설계의 구성 요소를 추상화할 수 있다는 것이다.

### 역할과 추상화

역할은 공통의 책임을 바탕으로 객체의 종류를 숨기기 때문에 이런 관점에서 역할의 객체의 추상화로 볼 수 있다. 따라서 추상화가 가지는 장점들이 협력의 관점에서도 역할에도 동일하게 적용될 수 있다.

### 배우와 배역

연극의 배역과 배우간의 관계의 특성

- 배역은 연극 배우가 특정 연극에서 연기하는 역할
- 배역은 연극이 상영되는 동안에만 존재하는 일시적인 개념
- 연극이 끝나면 연극 배우는 배역이라는 역할을 벗어 버리고 원래의 연극배우로 돌아온다.
- 동일한 배역을 여러 명의 배우들이 연기 할 수 있다.
- 하나의 배우가 다양한 연극 안에서 서로 다른 배역을 연기할 수있다.

연극 안에서 배역을 연기하는 배우라는 은유는 협력 안에서 역할을 수행한는 객체라는 관점이 가진 입체적인 측면들을 훌륭하게 담아낸다.

- 협력 = 연극 
- 코드 = 극본

- 역할은 객체의 페르소나다.

- 객체는 여러 역할을 가질 수 있지만 협력 안에서는 일시적으로 오직 하나의 역할만이 보여진다.
- 역할은 특정한 객체의 종류를 캡슐화하기 때문에 동일한 역할을 수행하고 계약을 준수하는 대체 가능한 객체들은 다형적이다.




