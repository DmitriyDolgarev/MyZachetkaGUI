package Data;

public class Chemist extends Discipline {
    private boolean laboratoryWork;
    public Chemist()
    {
        super();
        setName("Химия");
        setDifTests("Сдать контрольную работу.", "Написать исследовательскую работу.", "Сдать лабораторную работу.");
    }
    @Override
    public String[] getConditions()
    {
        String[] conditions=new String[5];
        conditions[0]="Условия получения аттестации";
        conditions[1]="Количество часов посещения: больше 2";
        conditions[2]="Количество оценок: от 3 и больше";
        conditions[3]="Выполнить лабораторную работу на оценку 3 и больше";
        conditions[4]="";
        return conditions;
    }
    @Override
    public int doLesson() {
        setHours(getHours()+1);
        certify();
        return getHours();
    }
    @Override
    public int startTest() {
        int randomMark=(int)(Math.random()*4)+2;
        addMark(String.valueOf(randomMark));
        if (randomMark>2)
        {
            setSuccess(true);
        }
        certify();
        return randomMark;
    }

    @Override
    public void certify() {
        if (getHours()>=2&&getCountOfMarks()>=3&&laboratoryWork)
        {
            setCertification(true);
        }
    }
    public void writeResearchWork()
    {
        setCertification(true);
        if (getCountOfMarks()<3)
        {
            while (getCountOfMarks()<3)
            {
                addMark(String.valueOf(5));
            }
        }
        if (getHours()<2)
        {
            setHours(2);
        }
        setSuccess(true);
        this.laboratoryWork=true;
    }
    public int doLaboratoryWork()
    {
        int random=(int)(Math.random()*4)+2;
        if (random>2)
        {
            this.laboratoryWork=true;
            addMark(String.valueOf(random));
            certify();
        }
        return random;
    }
}
