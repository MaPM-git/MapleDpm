package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ShieldChasingAfterSecond extends GaugeAttackSkill {
    public ShieldChasingAfterSecond() {
        this.setName("실드 체이싱(첫타 이후)");
        this.setAttackCount(2L);
        this.setDamage(840.0);
        this.setDotDuration(29 * 120L);
        this.setLimitAttackCount(29L);  // 실드 체이싱-엑스트라 타겟
        this.setInterval(180L);
        this.addFinalDamage(0.7);
        this.setAddDamage(20L + 20);    // 실드 체이싱-리인포스, 디펜스 엑스퍼타이즈
        this.addIgnoreDefenseList(30L); // 디펜스 엑스퍼타이즈
        this.addFinalDamage(2.2);   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
