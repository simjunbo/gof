# 장식자(DECORATOR)
## 의도
- 객체에 동적으로 새로운 책임을 추가할 수 있게 함
- 서브클래스를 생성하는 것보다 융통성 있는 방법을 제공함

## 다름 이름
- 랩퍼(Wrapper)

## 동기
- 전체 클래스에 새로운 기능을 추가할 필요는 없지만, 개별적인 객체에 새로운 책임을 추가할 필요가 있음
  - 일반적인 방법은 상속이지만 선택이 정적이기 때문에 유용하지 않음
  - 무언가를 감싸는 객체인 장식자를 사용
    - 장식자는 자신이 둘러싼 요소, 구성요소가 갖는 인터페이스를 자신도 동일하게 제공하므로, 장식자의 존재는 이를 사용하는 사용자에게 감춰짐

- 장식자는 자신이 둘러싼 구성요소로 전달되는 요청을 중간에 가로채서 해당 구성요소에 전달해 줌
  - 투명성이 존재하기 때문에 장식자의 중첩이 가능하며, 이를 통해 책임 추가를 무한적으로 할 수 있음

- ![decorator1](https://user-images.githubusercontent.com/7076334/136200003-8c5de7ec-162d-4d64-813c-77246d1a4d48.png)
  -  VisualComponent : 비주얼 객체를 위한 추상클래스로, 그리기와 이벤트 처리에 필요한 인터페이스 정의
  -  Decorator : 단순하게 Draw()에 대한 요청을 자신이 갖는 요소에 전달할 뿐.
  -  Decorator 서브 클래스(ScrollDecorator, BorderDecorator) : Draw() 연산을 확장하여 필요한 기능 구현. 필요한 서비스를 구현하기 위해서 특정 기능을 수행하는 메서드를 추가로 구현할 수 있음
    - 장식자 패턴의 중요 한 특성은 어떤 형태의 VisualComponent에 모두 적용 가능
    - TextView에만 추가적인 기능을 제공하는 것이 아니라, VisualComponent 클래스의 모든 서브클래스에 추가적인 기능 제공

## 활용성
- 장식자 패턴은 다음의 경우에 사용
  - 동적으로 또한 투명하게, 다시 말해 다른 객체에 영향을 주지 않고 개개의 객체에 새로운 책임을 추가하기 위해 사용
  - 제거될 수 있는 책임에 대해 사용
  - 실제 상속으로 서브클래스를 계속 만드는 방법이 실질적이지 못할 때 사용

## 구조
- ![decorator2](https://user-images.githubusercontent.com/7076334/136201341-b2b05df7-0514-4f3e-bdb3-af727b5dd690.png)

## 참여자
- Component(VisualComponent) : 동적으로 추가할 서비스를 가질 가능성이 있는 객체들에 대한 인터페이스
- ConcreteComponent(TextView) : 추가적인 서비스가 실제로 정의되어야 할 필요가 있는 객체
- Decorator : Component 객체에 대한 참조자를 관리하면서 Component에 정의된 인터페이스를 만족하도록 인터페이스를 정의
- ConcreteDecorator(ScrollDecorator, BorderDecorator) : Component에 새롭게 추가할 서비스를 실제로 구현하는 클래스

## 협력 방법
- Decorator는 자신의 Component 객체 쪽으로 요청을 전달
- 요청 전달 전 및 전달 후에 자신만의 추가 연산을 선택적으로 수행

## 결과
- 장식자 패턴을 쓰면서 얻는 이익과 부담은 각각 두 가지
  - 1) 단순한 상속보다 설계의 융통성을 더 많이 증대시킬 수 있음
    - 장식자 패턴은 객체에 새로운 행동을 추가할 수 있는 가장 효과적인 방법
    - 장식자를 사용하면 장식자를 객체와 연결하거나 분리하는 작업을 통해 새로운 책임을 추가하거나 삭제하는 일이 런타임에 가능. 상속은 정적으로 새로운 클래스를 추가해야만 가능
    - Decorator 클래스와 Component 클래스 사이에 집합 관계가 정의 되어 있어 Component 서브클래스들도 포함할 수 있게 됨
  - 2) 클래스 계통의 상부측 클래스에 많은 기능이 누적되는 상황을 피할 수 있음
    - 장식자 패턴은 책임 추가 작업에서 '필요한 비용만 그때 지불하는' 방법을 제공
      - 누락된 서비스들은 Decorator 객체를 통해 지속적으로 추가 가능  
    - 응용프로그램 개발 시 현재 사용되지 않은 기능까지 개발하기 위해 시간과 노력을 투자할 필요 없음
  - 3) 장식자와 해당 그 장식자의 구성요소가 동일한 것은 아님
    - 장식자는 사용자에게 일관된 인터페이스를 제공하는 껍데기
    - 그러므로 객체 식별자 관점에서 구성요소와 이를 둘러싼 Decorator 객체가 동일한 식별자를 가질 필요는 없음 
  - 4) 장식자를 사용함으로써 작은 규모의 객체들이 많이 생김
    - 클래스들이 어떻게 조합하여 새로운 모습과 기능을 만들어 내는가에 따라서 새로운 객체가 계속 만들어짐
    - 객체들을 잘 이해하고 있다면 시스템의 재정의가 쉽겠지만, 그렇지 않다면 객체들을 모두 이해하고 수정하는 과정이 복잡해짐 

## 구현
- 장식자 패턴을 사용할 때 고려할 사항들
  - 1) 인터페이스 일치시키기
    - Decorator 객체의 인터페이스는 반드시 자신을 둘러싼 구성요소의 인터페이스를 만족해야 함
  - 2) 추상 클래스로 정의되는 Decorator 클래스 생략하기
    - Decorator 클래스에 정의할 책임이 한 가지 밖에 존재하지 않을 때, 구성요소에게 요청을 전달하는 Decorator 클래스의 책임을 ConcreteDecorator 클래스와 합칠 수 있음
  - 3) Component 클래스는 가벼운 무게를 유지하기
    - 가볍게 정의한다는 의미는 연산에 해당하는 인터페이스만을 정의하고 무언가 저장할 수 있는 변수는 정의하지 말라는 의미
    - 데이터 저장소를 정의하는 것은 서브클래스에서 할 일
    - Component 클래스가 복잡해지면 상속받는 여러 Decorator 들도 복잡하고 무거운 클래스가 되어버림
  - 4) 객체의 겉포장을 변경할 것인가, 속을 변경할 것인가
    - 외부를 변경 : 장식자 패턴
    - 내부를 변경 : 전략 패턴
    - Component 클래스가 본질적으로 매우 복잡하고 무거운 특성을 갖는다면, 전략 패턴이 더 나은 방안
    - 


## 예제코드

```
/**
 * component
 */
public interface VisualComponent {
    void draw();

    void resize();
}

/**
 * decorator
 */
public class Decorator implements VisualComponent {
    private VisualComponent component;

    public Decorator(VisualComponent component) {
        this.component = component;
    }

    @Override
    public void draw() {
        component.draw();
    }

    @Override
    public void resize() {
        component.resize();
    }
}

/**
 * concrete decorator
 */
public class BorderDecorator extends Decorator {
    private int width;

    public BorderDecorator(VisualComponent component, int borderWidth) {
        super(component);
        this.width = borderWidth;
    }

    @Override
    public void draw() {
        super.draw();
        drawBorder(width);
    }

    /**
     * 외부에서 알 수 없도록 하기 위해
     */
    private void drawBorder(int w) {
        System.out.println("Drawing border with width=" + w);
    }
}

/**
 * concrete component
 */
public class TextView implements VisualComponent {
    @Override
    public void draw() {
        System.out.println("Drawing text view");
    }

    @Override
    public void resize() {
        System.out.println("Resizing text view");
    }
}

/**
 * composite 역할과 비슷
 */
public class Window {
    private List<VisualComponent> contents;

    public Window() {
        contents = new ArrayList<>();
    }

    public void addComponent(VisualComponent component) {
        this.contents.add(component);
    }

    public void draw() {
        for (int i = 0; i < contents.size(); i++) {
            System.out.println("*** Component " + (i + 1) + " ***");
            contents.get(i).draw();
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Window window = new Window();

        window.addComponent(new BorderDecorator(new ScrollDecorator(new TextView()), 30));

        window.addComponent(new ScrollDecorator(new TextView()));

        window.draw();
    }
}

```

## 잘 알려진 사용예
- java.io (InputStream)
- https://johngrib.github.io/wiki/pattern/decorator/

## 관련 패턴
- 적응자 패턴 : 적응자는 인터페이스를 변경시켜 주는 것이지만, 장식자는 객체의 책임, 행동을 변화시킴
- 복합체 패턴 :
  - 장식자는 한 구성요소만을 갖는 복합체로 볼 수 있음
  - 그럭나 이 목적은 객체의 합성이 아니라 객체에 새로운 행동을 추가하기 위한 것
- 전략 패턴 : 장식자는 객체의 겉모양을 변경하고, 전략은 객체의 내부를 변화시킴 (두 가지 다른 대안)  


# 퍼사드(FACADE)
## 의도
- 한 서브시스템 내의 인터페이스 집합에 대한 획일화된 하나의 인터페이스를 제공하는 패턴으로, 서브시스템을 사용하기 쉽도록 상위 수준의 인터페이스를 정의

## 동기
- 시스템을 서브시스템으로 구조화하면 복잡성을 줄이는 데에 큰 도움이 됨
- 공통 적인 설계 목표는 서브시스템들 사이의 의사소통 및 종속성을 최소화
- 주어진 서브시스템의 일반적인 기능에 대한 단순화된 하나의 인터페이스를 제공
- ![facade1](https://user-images.githubusercontent.com/7076334/136207862-f1e46bfd-4671-4ada-9e20-07d77ccc9305.png)
  - Compiler 클래스를 퍼사드 객체로 정의
  - Compiler 클래스 사용자에게는 컴파일러 시스템을 사용하는 데 필요한 가장 필수적인 인터펭피스만 제공하고, 내부적으로는 컴파일러 기능성을 구현하는 클래스들을 함께 동작하도록 묶어주는 역할

## 활용성
- 퍼사드 패턴은 다음의 경우에 사용
  - 복잡한 서브시스템에 대한 단순한 인터페이스 제공이 필요할 때
    - 이럴 때 퍼사드 패턴은 서브시스템에 대한 단순하면서도 기본적인 인터페이스를 제공함으로써 대부분의 개발자들에게 적합한 클래스 형태를 제공  
  - 추상 개념에 대한 구현 클래스와 사용자 사이에 너무 많은 종속성이 존재할 때
    - 퍼사드를 사용해서 사용자와 다른 서브시스템 간의 결합도를 줄일 수 있음
  - 서브시스템을 계층화시킬 때
    - 서브시스템이 다른 서브시스템에 종속적이라 하더라도, 각자가 제공하는 퍼사드를 통해서만 대화를 진행하게 함으로써 서브시스템 간의 종속성을 줄일 수 있음
    - 이로써 서브시스템 내부 설계의 변경이 다른 서브시스템에 독립적으로 자유롭게 될 수 있음

## 구조
- ![facade2](https://user-images.githubusercontent.com/7076334/136207869-f110281f-d65a-4726-9dd4-c9a1041a38c7.png)

## 참여자
- 퍼사드(Compiler) : 단순하고 일관된 통합 인터페이스를 제공하며, 서브시스템을 구성하는 어떤 클래스가 어떤 요청을 처리해야 하는지 알고 있으며, 사용자의 요청을 해당 서브시스템 객체에 전달
- 서브시스템 클래스들(Scanner, Parser, ProgramNode 등) : 서브시스템의 기능을 구현하고, Facade 객체로 할당된 작업을 실제로 처리하지만 Facade에 대한 아무런 정보가 없음

## 협력 방법
- 사용자는 Facade에 정의된 인터페이스를 이용해서 서브시스템과 상호작용함
  - Facade는 해당 요청을 서브시스템을 구성하는 적당한 객체에게 전달
- 퍼사드를 사용하는 사용자는 서브시스템을 구성하는 객체로 직접 접근하지 않아도 됨

## 결과
- 퍼사드 패턴을 사용하면 얻는 이익은 다음과 같음
  - 1) 서브시스템의 구성요소를 보호할 수 있음
    - 사용자가 다루어야 할 객체의 수가 줄어들며, 서브시스템을 쉽게 사용할 수 있음 
  - 2) 서브시스템과 사용자 코드 간의 결합도를 더욱 약하게 만듬
    - 서브시스템과 사용자 간의 결합이 약하면, 서브시스템 내의 요소를 다양화하는 작업을 원활하게 할 수 있음 
  - 3) 응용프로그램 쪽에서 서브시스템 클래스를 사용하는 것을 완전히 막지는 않음
    - 사용자는 Facade를 사용할지 서브시스템 클래스를 직접 사용할지 결정할 수 있음 

## 구현
- 퍼사드 패턴을 구현하기 위해 고려할 사항들
  - 1) 사용자와 서브시스템 간의 결합도 줄이기
    - 사용자와 서브시스템 간의 의존성을 줄이는 방법은 Facade를 추상 클래스로 정의하고, 서브시스템을 나타내기 위해 이를 상속하는 구체 서브클래스를 정의하여 다른 구현을 정의하도록 하는 것
  - 2) 서브시스템 클래스 중 공개할 것과 감출 것
    - 클래스는 상태와 연산을, 서브시스템은 클래스를 캡슐화함
    - 서브시스템의 공개 인터페이스는 사용자가 직접 접근할 수 있는 클래스들이고, 비공개 인터페이스는 서브시스템 자체가 됨

## 예제코드
```
/**
 * facade
 */
public class Compiler {
    public void compile(InputStream input, OutputStream output) {
        Scanner scanner = new Scanner(input);
        ProgramNodeBuilder builder = new ProgramNodeBuilder();
        Parser parser = new Parser();

        parser.parse(scanner, builder);

        RISCCodeGenerator generator = new RISCCodeGenerator(output);
        ProgramNode parseTree = builder.getRootNode();
        parseTree.traverse(generator);
    }
}

/**
 * client
 */
public class Client {
    public static void main(String[] args) {
        Compiler compiler = new Compiler();
        compiler.compile(System.in, System.out);
    }
}
```
- 퍼사드 패턴의 임무는 일반적인 사용을 위해 인터페이스를 간소화 하는 것

## 잘 알려진 사용예
- slf4j
  - ![slf4j](https://user-images.githubusercontent.com/7076334/136211296-8d99b674-5c93-4e8e-a0d7-10125d7e26e1.png)
  - https://sshplendid.github.io/blog/dev/designpattern/2020/02/24/facade-pattern/
  - https://team404.tistory.com/17

## 관련 패턴
- 추상 팩토리 패턴 : 서브시스템에 독립적인 방법으로, 서브시스템 객체를 생성하는 인터페이스를 제공하기 위해 Facade와 함께 사용 가능
- 중재자 패턴 : 
  - 중재자 패턴의 목적은 여러 객체들 사이의 협력 관계를 추상화하여 기능성의 집중화를 막자는 것
  - 중재자 패턴에 참여하는 객체는 서로를 직접 알지 못하고 단지 중재자를 통해서만 상호작용
  - 이에 비해 퍼사드는 서브시스템 인터페이스 자체를 추상화하여 사용을 용이하게 하려는 목적
- 단일체 : 퍼사드 객체가 하나만 있어도 된다면, 단일체로 구현 가능

