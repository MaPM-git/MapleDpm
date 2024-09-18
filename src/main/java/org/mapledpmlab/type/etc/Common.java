package org.mapledpmlab.type.etc;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.equipment.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Common {
    private Long att = 0L;
    private Long attP = 0L;
    private Long allStatP = 0L;
    private Long bossDamage = 0L;
    private Long cooldownReductionP = 0L;
    private Long cooldownReductionSec = 0L;
    private Double criticalDamage = 0.0;
    private Double criticalP = 0.0;
    private Long damage = 0L;
    private String description ="";
    private Double finalDamage = 1.0;
    private Long hp = 0L;
    private List<Long> ignoreDefenseList = new ArrayList<>();
    private Long level = 0L;
    private Long magic = 0L;
    private Long magicP = 0L;
    private Long mainStat = 0L;
    private Long mainStatP = 0L;
    private Long otherStat1 = 0L;
    private Long otherStat2 = 0L;
    private Long perXAtt = 0L;
    private Long perXMainStat = 0L;
    private Long perXOtherStat = 0L;
    private Long perXSubStat = 0L;
    private Long plusBuffDuration = 0L;
    private Long property = 0L;
    private Double reuse = 0.0;
    private Long statXDamage = 0L;
    private Double statXFinalDamage = 1.0;
    private List<Long> statXIgnoreDefenseList = new ArrayList<>();
    private Long subStat = 0L;

    public Double getIgnoreDefense() {
        Double ignoreDefense = 1.0;
        for (Long i : this.ignoreDefenseList) {
            ignoreDefense = ignoreDefense * (1 - i * 0.01);
        }
        return 1 - ignoreDefense;
    }

    public Double getStatXIgnoreDefense() {
        Double ignoreDefense = 1.0;
        for (Long i : this.statXIgnoreDefenseList) {
            ignoreDefense = ignoreDefense * (1 - i * 0.01);
        }
        return 1 - ignoreDefense;
    }

    public void addAtt(Long att) {
        this.att += att;
    }

    public void addAttP(Long attP) {
        this.attP += attP;
    }

    public void addAllStatP(Long allStatP) {
        this.allStatP += allStatP;
    }

    public void addBossDamage(Long bossDamage) {
        this.bossDamage += bossDamage;
    }

    public void addCooldownReductionP(Long cooldownReductionP) {
        this.cooldownReductionP += cooldownReductionP;
    }

    public void addCooldownReductionSec(Long cooldownReductionSec) {
        this.cooldownReductionSec += cooldownReductionSec;
    }

    public void addCriticalDamage(Double criticalDamage) {
        this.criticalDamage += criticalDamage;
    }

    public void addCriticalP(Double criticalP) {
        this.criticalP += criticalP;
    }

    public void addDamage(Long damage) {
        this.damage += damage;
    }

    public void addFinalDamage(Double finalDamage) {
        this.finalDamage *= finalDamage;
    }

    public void minusFinalDamage(Double finalDamage) {
        this.finalDamage /= finalDamage;
    }

    public void addHp(Long hp) {
        this.hp += hp;
    }

    public void addIgnoreDefenseList(Long ignoreDefense) {
        this.ignoreDefenseList.add(ignoreDefense);
    }

    public void addMagic(Long magic) {
        this.magic += magic;
    }

    public void addMagicP(Long magicP) {
        this.magicP += magicP;
    }

    public void addMainStat(Long mainStat) {
        this.mainStat += mainStat;
    }

    public void addMainStatP(Long mainStatP) {
        this.mainStatP += mainStatP;
    }

    public void addOtherStat1(Long otherStat1) {
        this.otherStat1 += otherStat1;
    }

    public void addPerXAtt(Long perXAtt) {
        this.perXAtt += perXAtt;
    }

    public void addPerXMainStat(Long perXMainStat) {
        this.perXMainStat += perXMainStat;
    }

    public void addPerXOtherStat(Long perXOtherStat) {
        this.perXOtherStat += perXOtherStat;
    }

    public void addPerXSubStat(Long perXSubStat) {
        this.perXSubStat += perXSubStat;
    }

    public void addOtherStat2(Long otherStat2) {
        this.otherStat2 += otherStat2;
    }

    public void addPlusBuffDuration(Long plusBuffDuration) {
        this.plusBuffDuration += plusBuffDuration;
    }

    public void addProperty(Long property) {
        this.property += property;
    }

    public void addReuse(Double reuse) {
        this.reuse += reuse;
    }

    public void addStatXFinalDamage(Double statXFinalDamage) {
        this.statXFinalDamage *= statXFinalDamage;
    }

    public void addStatXDamage(Long statXDamage) {
        this.statXDamage += statXDamage;
    }

    public void addStatXIgnoreDefeseList(Long statXIgnoreDefense) {
        this.statXIgnoreDefenseList.add(statXIgnoreDefense);
    }

    public void addSubStat(Long subStat) {
        this.subStat += subStat;
    }

    public void addTotal(JobType jobType) {
        List<Common> addList = new ArrayList<>();
        addList.add(new Badge());
        addList.add(new Belt(jobType));
        addList.add(new Bottom(jobType));
        addList.add(new Cape(jobType));
        addList.add(new Coordi());
        addList.add(new Earrings(jobType));
        addList.add(new Emblem());
        addList.add(new Eye(jobType));
        addList.add(new Face(jobType));
        addList.add(new Gloves(jobType));
        addList.add(new Hat(jobType));
        addList.add(new Heart());
        addList.add(new Medal());
        addList.add(new Pendant1(jobType));
        addList.add(new Pendant2(jobType));
        addList.add(new Pet());
        addList.add(new Pocket());
        addList.add(new Ring1(jobType));
        addList.add(new Ring2(jobType));
        addList.add(new Ring3(jobType));
        addList.add(new Ring4_Special());
        addList.add(new SetOption());
        addList.add(new Shoes(jobType));
        addList.add(new Shoulder(jobType));
        addList.add(new Symbol());
        addList.add(new Title());
        addList.add(new Top(jobType));

        for (Common c : addList) {
            this.addObject(c);
        }
    }

    public void addObject(List<Common> commonList) {
        for (Common common : commonList) {
            this.addObject(common);
        }
    }

    public void addObject(Common c) {
        this.addAtt(c.getAtt());
        this.addAttP(c.getAttP());
        this.addAllStatP(c.getAllStatP());
        this.addBossDamage(c.getBossDamage());
        this.addCooldownReductionP(c.getCooldownReductionP());
        this.addCooldownReductionSec(c.getCooldownReductionSec());
        this.addCriticalDamage(c.getCriticalDamage());
        this.addCriticalP(c.getCriticalP());
        this.addDamage(c.getDamage());
        this.addFinalDamage(c.getFinalDamage());
        this.addHp(c.getHp());
        for (Long ignoreDefense : c.getIgnoreDefenseList()) {
            this.addIgnoreDefenseList(ignoreDefense);
        }
        this.addMagic(c.getMagic());
        this.addMagicP(c.getMagicP());
        this.addMainStat(c.getMainStat());
        this.addMainStatP(c.getMainStatP());
        this.addOtherStat1(c.getOtherStat1());
        this.addOtherStat2(c.getOtherStat2());
        this.addPerXAtt(c.getPerXAtt());
        this.addPerXMainStat(c.getPerXMainStat());
        this.addPerXOtherStat(c.getPerXOtherStat());
        this.addPerXSubStat(c.getPerXSubStat());
        this.addPlusBuffDuration(c.getPlusBuffDuration());
        this.addProperty(c.getProperty());
        this.addReuse(c.getReuse());
        this.addStatXFinalDamage(c.getStatXFinalDamage());
        this.addStatXDamage(c.getStatXDamage());
        for (Long statXIgnoreDefense : c.getStatXIgnoreDefenseList()) {
            this.addStatXIgnoreDefeseList(statXIgnoreDefense);
        }
        this.addSubStat(c.getSubStat());
    }

    @Override
    public String toString() {
        String str = "\n";
        if (getAtt() != 0) {
            str += "\n공격력 : " + getAtt();
        }
        if (getAttP() != 0) {
            str += "\n공격력% : " + getAttP();
        }
        if (getAllStatP() != 0) {
            str += "\n올스탯% : " + getAllStatP();
        }
        if (getBossDamage() != 0) {
            str += "\n보스 공격 시 데미지 : " + getBossDamage();
        }
        if (getCooldownReductionP() != 0) {
            str += "\n쿨타임 감소% : " + getCooldownReductionP();
        }
        if (getCooldownReductionSec() != 0) {
            str += "\n쿨타임 감소 : " + getCooldownReductionSec();
        }
        if (getCriticalDamage() != 0) {
            str += "\n크리티컬 데미지 : " + getCriticalDamage();
        }
        if (getCriticalP() != 0) {
            str += "\n크리티컬 확률 : " + getCriticalP();
        }
        if (getDamage() != 0) {
            str += "\n데미지 : " + getDamage();
        }
        if (getFinalDamage() != 1) {
            str += "\n최종데미지 : " + getFinalDamage();
        }
        if (getHp() != 0) {
            str += "\nHP : " + getHp();
        }
        if (getIgnoreDefense() != 0) {
            str += "\n방어율 무시 : " + getIgnoreDefenseList();
        }
        if (getMagic() != 0) {
            str += "\n마력 : " + getMagic();
        }
        if (getMagicP() != 0) {
            str += "\n마력% : " + getMagicP();
        }
        if (getMainStat() != 0) {
            str += "\n주스탯 : " + getMainStat();
        }
        if (getMainStatP() != 0) {
            str += "\n주스탯% : " + getMainStatP();
        }
        if (getSubStat() != 0) {
            str += "\n부스탯 : " + getSubStat();
        }
        if (getOtherStat1() != 0) {
            str += "\n이외 스탯1 : " + getOtherStat1();
        }
        if (getOtherStat2() != 0) {
            str += "\n이외 스탯2 : " + getOtherStat2();
        }
        if (getPerXAtt() != 0) {
            str += "\n% 미적용 공격력 : " + getPerXAtt();
        }
        if (getPerXMainStat() != 0) {
            str += "\n% 미적용 주스탯 : " + getPerXMainStat();
        }
        if (getPerXSubStat() != 0) {
            str += "\n% 미적용 부스탯 : " + getPerXSubStat();
        }
        if (getPerXOtherStat() != 0) {
            str += "\n% 미적용 이외 스탯 : " + getPerXOtherStat();
        }
        if (getPlusBuffDuration() != 0) {
            str += "\n버프 지속 시간 : " + getPlusBuffDuration();
        }
        if (getProperty() != 0) {
            str += "\n속성 내성 무시 : " + getProperty();
        }
        if (getReuse() != 0) {
            str += "\n재사용 : " + getReuse();
        }
        if (getStatXFinalDamage() != 1) {
            str += "\n스탯창에 적용되지 않는 최종데미지 : " + getStatXFinalDamage();
        }
        if (getStatXDamage() != 0) {
            str += "\n스탯창에 적용되지 않는 데미지 : " + getStatXDamage();
        }
        if (getStatXIgnoreDefense() != 0) {
            str += "\n스탯창에 적용되지 않는 방어율 무시 : " + getStatXIgnoreDefenseList();
        }

        return str;
    }
}
