package org.mapledpmlab.type.skill.attackskill.wildhunter;

public class SummonJaguar extends JaguarSkill {
    public SummonJaguar() {
        this.setName("서먼 재규어");
        this.setDamage(170.0 + 30 + 40 + 50 + 150);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyCooldownReduction(false);
        this.setJaguarDelay(960L);
    }
}
