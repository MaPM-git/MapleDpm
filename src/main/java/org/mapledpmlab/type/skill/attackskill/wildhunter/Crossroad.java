package org.mapledpmlab.type.skill.attackskill.wildhunter;

public class Crossroad extends JaguarSkill {
    public Crossroad() {
        this.setName("크로스 로드");
        this.setDamage(735.0);
        this.setAttackCount(2L);
        this.setCooldown(7.0);
        this.setAddDamage(20L);         // 서먼 재규어-리인포스
        this.addFinalDamage(2.8);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setJaguarDelay(990L);
    }
}
