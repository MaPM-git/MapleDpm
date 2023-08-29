package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TranscendentCygnusBlessing extends BuffSkill {
    // 4초마다 데미지 8퍼 증가
    public TranscendentCygnusBlessing(Long burningTime) {
        this.setName("초월자 시그너스의 축복");
        this.addBuffDamage(30 + burningTime / 4000 * 8);
        this.setDelay(630L);
        this.setDuration(45L);
    }
}
