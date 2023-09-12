package org.mapledpmlab.type.skill.attackskill;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.Skill;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class AttackSkill extends Skill {
    private Long addDamage = 0L;
    private Long attackCount = 0L;
    private Double criticalP = 0.0;
    private Long cumulativeDamage = 0L;
    private Double damage = 0.0;
    private Long dotDuration = 0L;
    private Double finalDamage = 1.0;
    private List<Long> ignoreDefenseList = new ArrayList<>();
    private Long interval = 0L;
    private boolean isApplyFinalAttack = false;
    private boolean isFinalAttack = false;
    private Long limitAttackCount = 0L;
    private Long prop = 0L;
    private Long useCount = 0L;
    private Double share = 0.0;
    private Long colNum = 0L;

    public String getInfo() {
        String str = "";
        if (getDamage() != 0) {
            str = str + "퍼뎀 : " + getDamage();
            colNum ++;
        }
        if (getDelay() != 0) {
            str = str + "\n딜레이 : " + getDelay();
            colNum ++;
        }
        if (getCooldown() != 0) {
            str = str + "\n쿨타임 : " + getCooldown();
            colNum ++;
        }
        if (getAttackCount() != 0) {
            str = str + "\n공격횟수 : " + getAttackCount();
            colNum ++;
        }
        if (getInterval() != 0) {
            str = str + "\n공격주기 : " + getInterval();
            colNum ++;
        }
        if (getAddDamage() != 0) {
            str = str + "\n추가데미지 : " + getAddDamage();
            colNum ++;
        }
        if (getFinalDamage() != 1.0) {
            str = str + "\n추가최종데미지 : " + getFinalDamage();
            colNum ++;
        }
        if (getIgnoreDefense() != 0) {
            str = str + "\n추가방어율무시 : " + getIgnoreDefense();
            colNum ++;
        }
        if (getCriticalP() != 0) {
            str = str + "\n추가크리티컬확률 : " + getCriticalP();
            colNum ++;
        }
        if (isApplyReuse()) {
            str = str + "\n재사용적용";
            colNum ++;
        }
        if (isApplyFinalAttack()) {
            str = str + "\n파이널어택적용";
            colNum ++;
        }
        return str;
    }

    public void print() {
        System.out.println(getName());
        System.out.println("사용횟수 : " + useCount);
        System.out.println("누적데미지 : " + cumulativeDamage);
        System.out.println("점유율 : " + share + "\n");
    }

    public Object[] getOpject() {
        Object[] result = new Object[]{
                this.getName(), this.getUseCount(), this.getCumulativeDamage() + "", this.getShare(), this.getInfo()
        };
        return result;
    }

    public Double getIgnoreDefense() {
        Double ignoreDefense = 1.0;
        for (Long i : this.ignoreDefenseList) {
            ignoreDefense = ignoreDefense * (1 - i * 0.01);
        }
        return 1 - ignoreDefense;
    }

    public void addIgnoreDefenseList(Long ignoreDefense) {
        this.ignoreDefenseList.add(ignoreDefense);
    }

    public void addFinalDamage(Double finalDamage) {
        this.finalDamage *= finalDamage;
    }

    public void addCriticalP(Double criticalP) {
        this.criticalP += criticalP;
    }

    public void minusFinalDamage(Double finalDamage) {
        this.finalDamage /= finalDamage;
    }
}
