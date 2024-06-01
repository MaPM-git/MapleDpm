package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

import java.sql.Timestamp;

public class ShieldChasing extends GaugeAttackSkill {

    Timestamp shieldChasingEndTime = new Timestamp(-1);

    public ShieldChasing() {
        this.setName("실드 체이싱(첫타)");
        this.setAttackCount(2L);
        this.setDamage(840.0 + 20);     // 디펜스 엑스퍼타이즈
        this.setDelayByAttackSpeed(480L);
        this.setGaugePer(-8L);
        this.setRelatedSkill(new ShieldChasingAfterSecond());
        this.setAddDamage(20L + 20);    // 실드 체이싱-리인포스, 디펜스 엑스퍼타이즈
        this.addIgnoreDefenseList(30L); // 디펜스 엑스퍼타이즈
        this.setCooldown(6.0);
        this.addFinalDamage(2.2);   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyReuse(true);
    }
}
