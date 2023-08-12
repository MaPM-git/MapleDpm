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

    @Override
    public String toString() {
        String str = "";
        if (damage != 0) {
            str = str + "퍼뎀 : " + damage;
        }
        if (getDelay() != 0) {
            str = str + "\n딜레이 : " + getDelay();
        }
        return "AttackSkill{" +
                "addDamage=" + addDamage +
                ", attackCount=" + attackCount +
                ", criticalP=" + criticalP +
                ", cumulativeDamage=" + cumulativeDamage +
                ", damage=" + damage +
                ", dotDuration=" + dotDuration +
                ", finalDamage=" + finalDamage +
                ", ignoreDefenseList=" + ignoreDefenseList +
                ", interval=" + interval +
                ", isApplyFinalAttack=" + isApplyFinalAttack +
                ", isFinalAttack=" + isFinalAttack +
                ", limitAttackCount=" + limitAttackCount +
                ", prop=" + prop +
                ", useCount=" + useCount +
                ", share=" + share +
                '}';
    }

    public void print() {
        System.out.println(getName());
        System.out.println("사용횟수 : " + useCount);
        System.out.println("누적데미지 : " + cumulativeDamage);
        System.out.println("점유율 : " + share + "\n");
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
}
