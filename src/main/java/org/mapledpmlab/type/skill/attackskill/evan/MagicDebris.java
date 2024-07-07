package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagicDebris extends AttackSkill {
    public MagicDebris() {
        this.setName("마법 잔해");
        this.setAddDamage(22L);         // 다크 포그
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }

    public void setByCnt(Long cnt) {
        if (cnt == 15) {
            this.setDamage(425.0);
        } else if (cnt >= 10) {
            this.setDamage(324.0);
        } else if (cnt >= 5) {
            this.setDamage(223.0);
        } else {
            this.setDamage(122.0);
        }
        this.setAttackCount(cnt);
    }
}
