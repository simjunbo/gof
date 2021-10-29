# 중재자(MEDIATOR)
## 의도
- 한 집합에 속해 있는 객체의 상호작용을 캡슐화하는 객체를 정의
- 객체들이 직접 서로를 참조하지 않도록 하여 객체 사이의 소결합을 촉진시키며, 개발자가 객체의 상호작용을 독립적으로 다양화시킬 수 있게 만듬

## 동기
- 객체지향 개발 방법론에서는 행동을 여러 객체에게 분산시켜 처리하도록 권하고 있음
  - 이러한 행동의 분산으로 객체 구조는 수많은 연결 관계가 객체 사이에 존재하는 모습이 됨
  - 시스템은 자신의 행동을 처리하기 위해 다른 모든 객체에 대한 참조자를 관리해야 하는 최악의 상황에 직면할지도 모름

- 시스템을 여러 객체로 분할하면 객체의 재사용을 증대시킬 수 있음
  - 그러나 객체 분할이 객체 간 상호작용의 급증을 유발하고 이 때문에 재사용이 저하될 수도 있음
  - 또한 하나의 처리를 위해 수 많은 상호작용이 필요하므로 독립적이어야 한다는 객체의 특성이 유명무실해짐

- ![mediator1](https://user-images.githubusercontent.com/7076334/139284023-2cbe67f4-8e8e-4ba1-9ec7-b45556a16f88.png)
  - 이런 위젯 사이에 맺어진 종속성은 대화상자마다 다름
  - 따라서 어떤 대화상자가 동일한 종류의 위젯들로 구성되었다 하더라도 단순히 앞에서 정의한 위젯들을 그대로 재사용할 수 없음 (종속성에 따라 달라지기 때문이라고 이해함)
    - 지금 만들려는 대화상자에 정의한 위젯에 맞추어 새로운 클래스들을 만들어야 함

- 위의 경우 별도의 '중재자' 객체를 활용하면 상호작용과 관련된 행동을 하나의 객체로 모아서 이런 문제를 피할 수 있음
  - 중재자 객체는 객체 그룹 간의 상호작용을 제어하고 조화를 이루는 역할을 함
  - 그룹 내 객체들에 대한 포인터를 중재자 객체가 관리하기 떄문에, 객체들은 다른 객체에 대한 참조자 대신 단지 해당 중재자만 알면 됨 (채팅 서버)

- ![mediator2](https://user-images.githubusercontent.com/7076334/139285333-c14bd99e-ec3a-492f-af56-d40ccf4ee0cb.png)
  - FontDialogDirector 객체는 대화상자에 존재하는 위젯 간에 중재자 역할을 함
  - FontDialogDirector 객체는 대화상자에 있는 위젯들을 알고, 이들 간의 상호작용을 조정

- ![mediator3](https://user-images.githubusercontent.com/7076334/139285359-24b18802-b8ca-4a73-9de3-0265a1e04228.png)
  - 리스트 상자의 선택 변경 처리하는 과정에서 객체 간의 어떻게 처리되는지 상호작용 다이어그램
  - 리스트 상자의 선택으로 입력 창에 전달되는 일련의 이벤트 순서
    - 1) 리스트 상자는 지시자(director) 객체에게 자신이 변경되었음을 알림
    - 2) 지시자는 리스트 상자에서 선택된 부분이 무엇인지 알아옴
    - 3) 지시자는 입력 창에 선택 부분을 전달함
    - 4) 입력 창에는 어떤 값이 포함됨. 지시자는 관련된 버튼을 활성화 시킴
  - 위젯 끼리는 직접 메시지를 주고받지 않음 (단지 지시자가 누구인지만 알 뿐)

## 활용성
- 중재자 패턴은 다음의 경우에 사용
  - 여러 객체가 잘 정의된 형태이기는 하지만 복잡한 '상호작용'을 가질 때. 객체간의 의존성이 구조화되지 않으며, 잘 이해하기 어려울 때
  - 한 객체가 다른 객체를 너무 많이 참조하고, 너무 많은 의사소통을 수행해서 그 객체를 재사용하기 힘들 때
  - 여러 클래스에 분산된 행동들이 상속 없이 상황에 맞게 수정되어야 할 때 

## 구조 
- ![mediator5](https://user-images.githubusercontent.com/7076334/139287923-91064216-37b9-4e96-9ae4-09070976e6b5.png)


- 일반적인 객체 구조
- ![mediator6](https://user-images.githubusercontent.com/7076334/139287931-b51bffd3-b453-4c86-86cc-6b0738628e58.png)

## 참여자
- Mediator(DialogDirecetor) : Colleague 객체와 교류하는 데 필요한 인터페이스를 정의
- ConcreteMediator(FrontDialogDirector) : Colleauge 객체와 조화를 이뤄서 협력 행동을 구현하며, 자신이 맡은 동료(colleauge)를 파악하고 관리
- Colleague 클래스들(ListBox, EntryField)
  - 자신의 중재자 객체가 무엇인지 파악함
  - 다른 객체와 통신이 필요하면 그 중재자를 통해 통신되도록 하는 동료 객체를 나타내는 클래스

## 협력 방법
- Colleague는 Mediator에서 요청을 송수신 함. Mediator는 필요한 Colleauge 사이에 요청을 전달할 의무가 있음

## 결과
- 중재자 패턴에는 다음과 같은 장점과 단점이 있음
  - 1) 서브클래싱을 제한함
    - 중재자는 다른 객체 사이에 분산된 객체의 행동들을 하나의 객체로 국한함
    - 이 행동을 변경하고자 한다면 Mediator 클래스를 상속하는 서브클래스만 만들면 됨
    - Colleague 클래스는 여전히 재사용 가능 
  - 2) Colleauge 객체 사이의 종속성을 줄임
    - 중재자는 행동에 참여하는 객체간의 소결합을(low coupling) 증진시킴
    - 이로써 Mediator 클래스와 Colleague 클래스 각각을 독립적으로 다양화시킬 수 있고 재사용할 수 있음 
  - 3) 객체 프로토콜을 단순화함
    - 중재자는 다 대 다의 관계를 일 대 다의 관계로 축소시킴
    - 일 대 다의 관계가 훨씬 이해하기 쉬울 뿐만 아니라 유지하거나 확장하기 쉬움 
  - 4) 객체 간의 협력 방법을 추상화함
    - 객체 사이의 중재를 독립적인 개념으로 만들고 이것을 캡슐화함으로써, 사용자는 각 객체의 행동과 상관없이 객체간 연결 방법에만 집중할 수 있음
    - 결과적으로, 시스템에서 객체가 어떻게 동작하는지를 좀더 명확히 하는 데 도움이 됨 
  - 5) 통제가 집중화됨
    - 중재자 패턴은 상호작용의 복잡한 모든 것들이 자신 내부에서만 오가게 함
    - 중재자 객체는 동료 객체 간의 상호작용에 관련된 프로토콜을 모두 캡슐화하기 때문에 어느 동료 객체보다도 훨씬 복잡해질 수 있음
    - 이 때문에 Mediator 클래스 자체의 유지보수가 어려워질때도 있음

## 구현
- 중재자 패턴을 구현할 때 고려해야 할 이슈는 다음과 같음
  - 1) 추상 클래스인 Mediator 생략
    - 만약 관련 객체들이 오직 하나의 Mediator 클래스와 동작한다면 추상 클래스로 정의할 필요 없음
    - 추상 클래스의 목적은 앞으로 또 다른 상호작용을 정의할 새로운 Mediator 서브클래스를 만들 떄를 대비하는 것
  - 2) 동료 객체-중재자 객체 간 의사소통 
    - Mediator 클래스를 구현하는 한 가지 방법은 감시자 패턴을 사용하는 방법임
      - Colleague 객체가 주관자(subject) 객체로 동작하여 상태의 변화가 일어날 때마다 중재자에게 통보하면, 중재자는 처리 방법에 따라 다른 객체들에게 변경을 통보하여 처리
    - 또 다른 방법은 Mediator 클래스 내에 특화된 통지 인터페이스를 정의하여 동료 객체들이 직접 통신하게 하는 것

## 예제 코드
```
/**
 * Mediator
 */
public abstract class DialogDirector {
    public abstract void showDialog();

    public abstract void widgetChanged(Widget widget);

    protected abstract void createWidgets();
}

/**
 * Colleague
 */
public abstract class Widget {
    private DialogDirector director;

    public Widget(DialogDirector director) {
        this.director = director;
    }

    public void changed() {
        if (director != null) {
            director.widgetChanged(this);
        }
    }

    public void handleMouse(MouseEvent event) {
        System.out.println("Widget: handling mouse event");
    }
}

/**
 * ConcreteColleague
 */
public class ListBox extends Widget {
    public ListBox(DialogDirector director) {
        super(director);
    }

    public String getSelection() {
        return null;
    }

    @Override
    public void handleMouse(MouseEvent event) {
        super.handleMouse(event);
    }
}

/**
 * ConcreteColleague
 */
public class EntryField extends Widget {
    private String value;

    public EntryField(DialogDirector director) {
        super(director);
    }

    public String getText() {
        return value;
    }

    public void setText(String value) {
        this.value = value;
    }

    @Override
    public void handleMouse(MouseEvent event) {
        super.handleMouse(event);
    }
}

/**
 * ConcreteColleague
 */
public class Button extends Widget {
    private String text;

    public Button(DialogDirector director) {
        super(director);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void handleMouse(MouseEvent event) {
        changed();
    }
}

/**
 * ConcreteMediator
 */
public class FontDialogDirector extends DialogDirector {
    private Button ok;
    private Button cancel;
    private ListBox fontList;
    private EntryField fontName;

    @Override
    protected void createWidgets() {
        this.ok = new Button(this);
        this.cancel = new Button(this);
        this.fontList = new ListBox(this);
        this.fontName = new EntryField(this);
    }

    @Override
    public void showDialog() {
        System.out.println("FontDialogDirector: showing dialog");
    }

    @Override
    public void widgetChanged(Widget changedWidget) {
        if (changedWidget == fontList) {
            System.out.println("Setting fontName.text = fontList.getSelection()");
            fontName.setText(fontList.getSelection());
        } else if (changedWidget == ok) {
            System.out.println("Modifying font");
        } else if (changedWidget == cancel) {
            System.out.println("Closing the dialog");
        }
    }

    public static void pressOk(FontDialogDirector director) {
        director.ok.handleMouse(new MouseEvent());
    }
}
```
- DialogDirector : 지시자에 대한 인터페이스 정의
- Widget
  - 위젯에 대한 추상 기본 클래스로 지시자가 누구인지 암
  - changed 연산은 director 인스턴스 변수가 참조하는 객체의 widgetChanged 연산을 호출하여 변경 사실을 알림 
  - DialogDirector 서브클래스는 widgetChanged() 연산을 재정의하여 적절하게 Widget 클래스가 변화되도록 함
- ListBox, EntryField, Button
  - Widget의 서브클래스로 구체적인 사용자 인터페이스 요소들
- FontDialogDirector
  - 대화상자에 정의한 위젯 간의 중재 역할을 수행
  - FontDialogDirector 클래스는 자신이 화면에 표시한 위젯에 대한 정보를 계속 추적
  - createWidgets() 연산을 재정의하여 위젯을 생성
  - widgetChanged() 연산은 관련된 위젯들이 함께 적절히 동작할 수 있도록 함

- 중재자 패턴이 복잡해지면 다른 응용분야에서 패턴의 장점은 희석됨

## 잘 알려진 사용예
- 채팅 서버

## 관련 패턴
- 퍼사드 패턴은 객체들로 구성된 서브시스템을 추상화하여 좀더 편한 인터페이스를 제공하려는 것으로 중재자 패턴과는 좀 다름
- Facade 객체는 서브시스템을 구성하는 객체로만 메시지가 전달 (단방향)
- 그러나 중재자 객체는 양방향
- 상호 관련된 객체들은 감시자 패턴을 이용해서 중재자 객체들과 교류
