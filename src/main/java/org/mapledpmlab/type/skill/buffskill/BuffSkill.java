package org.mapledpmlab.type.skill.buffskill;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.Skill;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BuffSkill extends Skill {
    private Long duration = 0L;
    private Long buffAttMagic;
    private Long buffAttMagicPer;
    private Long buffAllStatP;
    private Double buffCriticalDamage;
    private Double buffCriticalP;
    private Long buffDamage;
    private Double buffFinalDamage;
    private Long buffIgnoreDefense;
    private List<Long> buffIgnoreDefenseList;
    private Long buffMainStat;
    private Long buffMainStatP;
    private Long buffOtherStat1;
    private Long buffOtherStat2;
    private Long buffProperty;
    private Double buffPlusFinalDamage;
    private Long buffSubStat;
    private boolean isApplyPlusBuffDuration = false;

    public BuffSkill() {
        this.buffAttMagic = 0L;
        this.buffAttMagicPer = 0L;
        this.buffAllStatP = 0L;
        this.buffCriticalDamage = 0.0;
        this.buffCriticalP = 0.0;
        this.buffDamage = 0L;
        this.buffFinalDamage = 1.0;
        this.buffIgnoreDefense = 0L;
        this.buffIgnoreDefenseList = new ArrayList<>();
        this.buffMainStat = 0L;
        this.buffMainStatP = 0L;
        this.buffOtherStat1 = 0L;
        this.buffOtherStat2 = 0L;
        this.buffProperty = 0L;
        this.buffPlusFinalDamage = 0.0;
        this.buffSubStat = 0L;
    }

    public Double getIgnoreDefense() {
        Double ignoreDefense = 1.0;
        for (Long i : this.buffIgnoreDefenseList) {
            ignoreDefense = ignoreDefense * (1 - i * 0.01);
        }
        return 1 - ignoreDefense;
    }

    public void addBuffAttMagic(Long buffAttMagic) {
        this.buffAttMagic += buffAttMagic;
    }

    public void addBuffAttMagicPer(Long buffAttMagicPer) {
        this.buffAttMagicPer += buffAttMagicPer;
    }

    public void addBuffAllStatP(Long buffAllStatP) {
        this.buffAllStatP += buffAllStatP;
    }

    public void addBuffCriticalDamage(Double buffCriticalDamage) {
        this.buffCriticalDamage += buffCriticalDamage;
    }

    public void addBuffCriticalP(Double buffCriticalP) {
        this.buffCriticalP += buffCriticalP;
    }

    public void addBuffDamage(Long buffDamage) {
        this.buffDamage += buffDamage;
    }

    public void addBuffFinalDamage(Double buffFinalDamage) {
        this.buffFinalDamage *= buffFinalDamage;
    }

    public void addBuffIgnoreDefense(Long buffIgnoreDefense) {
        this.buffIgnoreDefenseList.add(buffIgnoreDefense);
    }

    public void addBuffMainStat(Long buffMainStat) {
        this.buffMainStat += buffMainStat;
    }

    public void addBuffMainStatP(Long buffMainStatP) {
        this.buffMainStatP += buffMainStatP;
    }

    public void addBuffOtherStat1(Long buffOtherStat1) {
        this.buffOtherStat1 += buffOtherStat1;
    }

    public void addBuffOtherStat2(Long buffOtherStat2) {
        this.buffOtherStat2 += buffOtherStat2;
    }

    public void addBuffProperty(Long buffProperty) {
        this.buffProperty += buffProperty;
    }

    public void addBuffPlusFinalDamage(Double buffPlusFinalDamage) {
        this.buffPlusFinalDamage += buffPlusFinalDamage;
    }

    public void addBuffSubStat(Long buffSubStat) {
        this.buffSubStat += buffSubStat;
    }
}
