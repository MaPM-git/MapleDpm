package org.mapledpmlab.type.skill.attackskill.wildhunter;

public class JaguarSoul extends JaguarSkill {
    public JaguarSoul() {
        this.setName("재규어 소울");
        this.setDamage(462.0);
        this.setAttackCount(12L);
        this.setAddDamage(20L);             // 서먼 재규어-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setJaguarDelay(1320L);
        this.setCooldown(120.0);
    }
}
